package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.models.Breads.Baguette;
import se.groceriesstore.demo.models.Breads.Toast;
import se.groceriesstore.demo.services.BreadService;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/breads")
public class BreadController {

    @Autowired
    ProductService productService;

    @Autowired
    BreadService breadService;

    @GetMapping()
    public List<Bread> getAllBreads(){
        return productService.getAllBreads();
    }

    @GetMapping("/{id}")
    public Bread getBreadByID(@PathVariable("id") Integer id ) {
        return productService.getBreadById(id);
    }

    @PostMapping
    public Bread addBread(@RequestBody Bread bread) {
        return productService.addBread(bread);
    }

    @DeleteMapping("/{id}")
    public void deleteBread(@PathVariable("id") Integer id) {
       productService.deleteBread(id);
    }


    @GetMapping("/baguette")
    public List<Baguette> getAllBaguettes(){
        return breadService.getAllBaguettes();
    }

    @GetMapping("/baguette/{id}")
    public Baguette getBaguetteByID(@PathVariable("id") Integer id ) {
        return breadService.getBaguetteById(id);
    }

    @PostMapping("/baguette")
    public void addBaguette(@RequestBody Baguette baguette) {
        breadService.addBaguette(baguette);
    }

    @DeleteMapping("/baguette/{id}")
    public void deleteBaguette(@PathVariable("id") Integer id) {
        breadService.deleteBaguette(id);}


    @GetMapping("/toast")
    public List<Toast> getAllToasts(){
        return breadService.getAllToasts();
    }

    @GetMapping("/toast/{id}")
    public Toast getToastByID(@PathVariable("id") Integer id ) {
        return breadService.getToastById(id);
    }

    @PostMapping("/toast")
    public void addToast(@RequestBody Toast toast) {
        breadService.addToast(toast);
    }

    @DeleteMapping("/toast/{id}")
    public void deleteToast(@PathVariable("id") Integer id) {
        breadService.deleteToast(id);}
}