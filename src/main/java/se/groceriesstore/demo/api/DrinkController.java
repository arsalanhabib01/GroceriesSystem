package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Drink;
import se.groceriesstore.demo.services.DrinkService;


import java.util.List;

@RestController
public class DrinkController {

    @Autowired
    DrinkService drinkService;

    @GetMapping("/drinkdata")
    public List<Drink> getDrinks(){
        return drinkService.getDrinks();
    }
}