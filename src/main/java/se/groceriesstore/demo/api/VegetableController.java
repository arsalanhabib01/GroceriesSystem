package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Vegetable;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
public class VegetableController {

    @Autowired
    ProductService productService;

    @GetMapping("/vegetabledata")
    public List<Vegetable> getVegetables(){
        return productService.getVegetables();
    }
}