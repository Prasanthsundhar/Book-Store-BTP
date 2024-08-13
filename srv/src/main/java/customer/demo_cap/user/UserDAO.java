package customer.demo_cap.user;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import customer.demo_cap.user.User;

/**
 * InnerUserDAO
 */
public interface UserDAO extends JpaRepository<User, Long> {

} 
