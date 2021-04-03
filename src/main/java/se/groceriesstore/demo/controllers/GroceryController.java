package se.groceriesstore.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.groceriesstore.demo.services.DrinkService;
import se.groceriesstore.demo.services.ProductService;

@Controller
public class GroceryController {

    @Autowired
    ProductService productService;

    @Autowired
    DrinkService drinkService;

    @RequestMapping("/index")
    public String start(){
        return "index";
    }

    @RequestMapping("products")
    public String showProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "products";
    }

    @RequestMapping("breads")
    public String showBreads(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "breads";
    }

    @RequestMapping("drinks")
    public String showDrinks(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "drinks";
    }

    @RequestMapping("fruits")
    public String showFruits(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "fruits";
    }

    @RequestMapping("vegetables")
    public String showVegetables(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "vegetables";
    }

    @RequestMapping("kaffe")
    public String showKaffes(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        model.addAttribute("kaffe", drinkService.getAllKaffes());
        return "kaffe";
    }

    @RequestMapping("mjölk")
    public String showMilks(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        model.addAttribute("milk", drinkService.getAllMilks());
        return "mjölk";
    }

    @RequestMapping("läsk")
    public String showSodas(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        model.addAttribute("soda", drinkService.getAllSodas());
        return "läsk";
    }

    @RequestMapping("juice")
    public String showJuices(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        model.addAttribute("juice", drinkService.getAllJuices());
        return "juice";
    }

  /*   @RequestMapping("login")
    public String showlogain(Model model){
        model.addAttribute("login", productService.getLogin());
        return "login";
    }*/

}

