package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Fruit;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
public class FruitController {

    @Autowired
    ProductService productService;

    @GetMapping("/fruitdata")
    public List<Fruit> getFruits(){
        return productService.getFruits();
    }
}