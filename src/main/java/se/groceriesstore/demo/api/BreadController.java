package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.services.BreadService;

import java.util.List;

@RestController
public class BreadController {

    @Autowired
    BreadService breadService;

    @GetMapping("/breaddata")
    public List<Bread> getBreads(){
        return breadService.getBreads();
    }
}