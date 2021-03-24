package se.groceriesstore.demo.services;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.models.Drink;
import se.groceriesstore.demo.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    public List<Product> getProducts(){

        List<Product> products = new ArrayList<>();

        products.add(new Bread("Ljust bröd",20));
        products.add(new Bread("Grovt bröd",30));
        products.add(new Bread("Knäckebröd",10));
        products.add(new Drink("Cocacola",15));
        products.add(new Drink("Sprite",18));
        products.add(new Drink("Pepsi",20));
        return products;
    }
}
