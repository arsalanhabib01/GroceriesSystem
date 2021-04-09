package se.groceriesstore.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String formlogin(){
        return "login";
    }


    @RequestMapping("/newuser")
    public String newUser(){
        return "newuser";
    }
}