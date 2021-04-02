package se.groceriesstore.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggedController {

    @RequestMapping("/logged")
    public String logged(){
        return "logged";
    }
}