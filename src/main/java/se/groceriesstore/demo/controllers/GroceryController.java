package se.groceriesstore.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.groceriesstore.demo.services.ProductService;

@Controller
public class GroceryController {

    @Autowired
    ProductService productService;

    @RequestMapping("/index")
    public String start(){
        return "index";
    }

    @RequestMapping("products")
    public String showProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("breads", productService.getBreads());
        model.addAttribute("drinks", productService.getDrinks());
        model.addAttribute("fruits", productService.getFruits());
        model.addAttribute("vegetables", productService.getVegetables());
        return "products";
    }

    @RequestMapping("breads")
    public String showBreads(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        return "breads";
    }

    @RequestMapping("drinks")
    public String showDrinks(Model model){
        model.addAttribute("drinks", productService.getDrinks());
        return "drinks";
    }

    @RequestMapping("fruits")
    public String showFruits(Model model){
        model.addAttribute("fruits", productService.getFruits());
        return "fruits";
    }

    @RequestMapping("vegetables")
    public String showVegetables(Model model){
        model.addAttribute("vegetables", productService.getVegetables());
        return "vegetables";
    }
    @RequestMapping("login")
    public String showlogain(Model model){
        model.addAttribute("login", productService.getLogin());
        return "login";
    }

}

