package se.groceriesstore.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.User;
import se.groceriesstore.demo.services.UserService;

import java.util.List;




@RestController
@RequestMapping("/api/")
@Controller
public class NewUserController {
    @Autowired
    final UserService userService;

    public NewUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("users")
    public String showUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("newuser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable("email")String email, @RequestBody User newUser){
        return userService.updateUser(newUser,email);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }
}
