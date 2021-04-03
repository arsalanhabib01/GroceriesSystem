package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.groceriesstore.demo.models.Drink;
import se.groceriesstore.demo.models.Drinks.Juice;
import se.groceriesstore.demo.models.Drinks.Kaffe;
import se.groceriesstore.demo.models.Drinks.Milk;
import se.groceriesstore.demo.models.Drinks.Soda;
import se.groceriesstore.demo.services.DrinkService;
import se.groceriesstore.demo.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    @Autowired
    ProductService productService;

    @Autowired
    DrinkService drinkService;

    @GetMapping()
    public List<Drink> getAllDrinks(){
        return productService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public Drink getDrinkByID(@PathVariable("id") Integer id ) {
        return productService.getDrinkById(id);
    }

    @PostMapping()
    public void addDrink(@RequestBody Drink drink) {
        productService.addDrink(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable("id") Integer id) {
        productService.deleteDrink(id);
    }


    @GetMapping("/kaffe")
    public List<Kaffe> getAllKaffes(){
        return drinkService.getAllKaffes();
    }

    @GetMapping("/kaffe/{id}")
    public Kaffe getKaffeByID(@PathVariable("id") Integer id ) {
        return drinkService.getKaffeById(id);
    }

    @PostMapping("/kaffe")
    public void addKaffe(@RequestBody Kaffe kaffe) {
        drinkService.addKaffe(kaffe);
    }

    @DeleteMapping("/kaffe/{id}")
    public void deleteKaffe(@PathVariable("id") Integer id) {
        drinkService.deleteKaffe(id);
    }


    @GetMapping("/milk")
    public List<Milk> getAllMilks(){
        return drinkService.getAllMilks();
    }

    @GetMapping("/milk/{id}")
    public Milk getMilkByID(@PathVariable("id") Integer id ) {
        return drinkService.getMilkById(id);
    }

    @PostMapping("/milk")
    public void addMilk(@RequestBody Milk milk) {
        drinkService.addMilk(milk);
    }

    @DeleteMapping("/milk/{id}")
    public void deleteMilk(@PathVariable("id") Integer id) {
        drinkService.deleteMilk(id);
    }


    @GetMapping("/soda")
    public List<Soda> getAllSodas(){
        return drinkService.getAllSodas();
    }

    @GetMapping("/soda/{id}")
    public Soda getSodaByID(@PathVariable("id") Integer id ) {
        return drinkService.getSodaById(id);
    }

    @PostMapping("/soda")
    public void addSoda(@RequestBody Soda soda) {
        drinkService.addSoda(soda);
    }

    @DeleteMapping("/soda/{id}")
    public void deleteSoda(@PathVariable("id") Integer id) {
        drinkService.deleteSoda(id);
    }


    @GetMapping("/juice")
    public List<Juice> getAllJuices(){
        return drinkService.getAllJuices();
    }

    @GetMapping("/juice/{id}")
    public Juice getJuiceByID(@PathVariable("id") Integer id ) {
        return drinkService.getJuiceById(id);
    }

    @PostMapping("/juice")
    public void addJuice(@RequestBody Juice juice) {
        drinkService.addJuice(juice);
    }

    @DeleteMapping("/juice/{id}")
    public void deleteJuice(@PathVariable("id") Integer id) {
        drinkService.deleteJuice(id);
    }

}