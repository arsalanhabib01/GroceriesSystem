package se.groceriesstore.demo.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.User;
import se.groceriesstore.demo.services.UserService;
import java.util.List;
@RestController
@RequestMapping("/api/login")
public class LoginController {
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String email){
        return userService.getUserById(email);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id")String email, @RequestBody User newUser){
        return userService.updateUser(newUser, email);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String email) {
        userService.deleteUser(email);
    }

}
