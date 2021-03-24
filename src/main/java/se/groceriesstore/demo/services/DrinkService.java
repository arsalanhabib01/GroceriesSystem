package se.groceriesstore.demo.services;
import org.springframework.stereotype.Service;
import se.groceriesstore.demo.models.Drink;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkService {

    public List<Drink> getDrinks(){
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Cocacola",15));
        drinks.add(new Drink("Sprite",18));
        drinks.add(new Drink("Pepsi",20));
        return drinks;
    }
}
