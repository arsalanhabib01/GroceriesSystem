package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.User;
import se.groceriesstore.demo.services.UserService;


@RestController
@RequestMapping("/api/newuser")

public class NewUserController {
    @Autowired
    final UserService userService;

    public NewUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
