package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/breads")
public class BreadController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Bread> getAllBreads(){
        return productService.getAllBreads();
    }

    @GetMapping("/{id}")
    public Bread getBreadByID(@PathVariable("id") Integer id ) {
        return productService.getBreadById(id);
    }

    @PostMapping
    public void addBread(@RequestBody Bread bread) {
        productService.addBread(bread);
    }

    @DeleteMapping("/{id}")
    public void deleteBread(@PathVariable("id") Integer id) {
       productService.deleteBread(id);
    }

    @PutMapping("/{id}")
    public void updateBread (@PathVariable("id") Integer id,
                             @RequestBody Integer price) {
        productService.updateBread(id, price);
    }
}