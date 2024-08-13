package customer.demo_cap.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.lang.String;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import customer.demo_cap.user.User;
import customer.demo_cap.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required = true)
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            Optional<User> user = userService.findUserById(id);
            if (user.isPresent()) {
                return new ResponseEntity(user, HttpStatus.OK);
            } else {
                return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity(userService.findUserById(id), HttpStatus.BAD_REQUEST);
        }

    }
}