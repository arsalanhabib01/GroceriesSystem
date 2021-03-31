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
        model.addAttribute("breads", productService.getAllBreads());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("fruits", productService.getAllFruits());
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "products";
    }

    @RequestMapping("breads")
    public String showBreads(Model model){
        model.addAttribute("breads", productService.getAllBreads());
        return "breads";
    }

    @RequestMapping("drinks")
    public String showDrinks(Model model){
        model.addAttribute("drinks", productService.getAllDrinks());
        return "drinks";
    }

    @RequestMapping("fruits")
    public String showFruits(Model model){
        model.addAttribute("fruits", productService.getAllFruits());
        return "fruits";
    }

    @RequestMapping("vegetables")
    public String showVegetables(Model model){
        model.addAttribute("vegetables", productService.getAllVegetables());
        return "vegetables";
    }
  /*   @RequestMapping("login")
    public String showlogain(Model model){
        model.addAttribute("login", productService.getLogin());
        return "login";
    }*/

}

