package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/breads")
public class BreadController {

    @Autowired
    ProductService productService;

    @GetMapping("/breaddata")
    public List<Bread> getAllBreads(){
        return productService.getAllBreads();
    }


    @GetMapping("/{id}")
    public Bread getBreadByID(@PathVariable("id") UUID id ) {
        return productService.getBreadById(id)
                .orElse(null);
    }

    @PostMapping
    public void addBread(@RequestBody Bread bread) {
        productService.addBread(bread);
    }

    @DeleteMapping("/{id}")
    public int deleteBread(@PathVariable("id") UUID id) {
        return productService.deleteBread(id);
    }
}