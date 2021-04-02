package se.groceriesstore.demo.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewUserController {
    @RequestMapping("/newuser")
    public String formNewUser(){
        return "newuser";
    }
}

