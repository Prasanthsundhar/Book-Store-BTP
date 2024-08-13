package customer.demo_cap.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import customer.demo_cap.user.User;
import customer.demo_cap.user.UserDAO;

@Service
public class UserService {

    @Autowired(required = true)
    UserDAO userDAO;

    public Optional<User> findUserById(Long id) {
        return  userDAO.findById(id);
       // return user;
    }

}
