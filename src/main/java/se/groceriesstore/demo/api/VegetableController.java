package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Vegetable;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/vegetables")
public class VegetableController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Vegetable> getAllVegetables(){
        return productService.getAllVegetables();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableByID(@PathVariable("id") Integer id ) {
        return productService.getVegetableById(id);
    }

    @PostMapping
    public void addVegetable(@RequestBody Vegetable vegetable) {
        productService.addVegetable(vegetable);
    }

    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable("id") Integer id) {
        productService.deleteVegetable(id);
    }

}