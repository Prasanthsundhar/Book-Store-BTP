package customer.demo_cap.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import customer.demo_cap.user.User;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;

/**
 * InnerUserDAO
 */
@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private User user;

    public Optional<User> getUserById(Long id) {
        String procedureCALL = "{CALL  \"DEMO_CAP_HDI_DEMO_CAP_DB_DEPLOYER_1\".\"user_get_by_id\"(?)}";
        try {
            return jdbcTemplate.execute((Connection connection) -> {
                try (CallableStatement callableStatement = connection.prepareCall(procedureCALL)) {
                    callableStatement.setLong(1, id);
                    boolean hasResultSet = callableStatement.execute();
                    if (hasResultSet) {
                        try (ResultSet resultSet = callableStatement.getResultSet()) {
                            if (resultSet.next()) {
                                long getid = resultSet.getLong("id");
                                String userName = resultSet.getString("userName");
                                String email = resultSet.getString("email");
                                long userRoleId = resultSet.getLong("userRoleId");
    
                                User user = new User(getid, userName, email, userRoleId); // Assuming you have a User constructor
                                return Optional.of(user);
                            }
                        }
                    }
                    return Optional.empty();
                } catch (Exception e) {
                    e.printStackTrace(); // Handle or log exception appropriately
                    return Optional.empty();
                }
            });
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log exception appropriately
            return Optional.empty();
        }
    }
    

}
