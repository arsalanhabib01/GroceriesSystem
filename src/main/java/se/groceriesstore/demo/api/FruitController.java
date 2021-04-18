package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Fruit;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Fruit> getAllFruits(){
        return productService.getAllFruits();
    }

    @GetMapping("/{id}")
    public Fruit getFruitByID(@PathVariable("id") Integer id ) {
        return productService.getFruitById(id);
    }

    @PostMapping
    public Fruit addFruit(@RequestBody Fruit fruit) {
        return productService.addFruit(fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable("id") Integer id) {
        productService.deleteFruit(id);
    }

}