package se.groceriesstore.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/breads")
public class BreadController {

    @Autowired
    ProductService productService;

    @GetMapping("/breaddata")
    public List<Bread> getAllBreads(){
        return productService.getAllBreads();
    }
}