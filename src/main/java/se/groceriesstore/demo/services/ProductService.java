package se.groceriesstore.demo.services;

import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.stereotype.Service;
import se.groceriesstore.demo.models.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

     //   for(int i= 0; i < getBreads().size(); i++)
       for(Bread breads: getBreads())
            products.add(breads);

        for (Drink drinks: getDrinks())
            products.add(drinks);

        for (Fruit fruits: getFruits())
            products.add(fruits);

        for (Vegetable vegetables: getVegetables())
            products.add(vegetables);

        return products;
    }

    public List<Bread> getBreads(){
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread("Ljust bröd",20));
        breads.add(new Bread("Grovt bröd",30));
        breads.add(new Bread("Knäckebröd",10));
        return breads;
    }

    public List<Drink> getDrinks(){
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Cocacola",15));
        drinks.add(new Drink("Sprite",18));
        drinks.add(new Drink("Pepsi",20));
        return drinks;
    }

    public List<Fruit> getFruits(){
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Äpple",12));
        fruits.add(new Fruit("Orange",23));
        fruits.add(new Fruit("Mango",35));
        return fruits;
    }

    public List<Vegetable> getVegetables(){
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable("Sallat",21));
        vegetables.add(new Vegetable("Spenat",19));
        vegetables.add(new Vegetable("Broccoli",9));
        return vegetables;
    }

}
