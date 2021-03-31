package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Drink;
import se.groceriesstore.demo.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Drink> getAllDrinks(){
        return productService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public Drink getDrinkByID(@PathVariable("id") Integer id ) {
        return productService.getDrinkById(id);
    }

    @PostMapping
    public void addDrink(@RequestBody Drink drink) {
        productService.addDrink(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable("id") Integer id) {
        productService.deleteDrink(id);
    }

}