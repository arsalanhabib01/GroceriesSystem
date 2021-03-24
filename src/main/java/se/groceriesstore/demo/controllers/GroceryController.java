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
        return "products";
    }
}

