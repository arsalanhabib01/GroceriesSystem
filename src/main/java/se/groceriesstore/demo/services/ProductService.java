package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.BreadsDAO;
import se.groceriesstore.demo.models.*;
import se.groceriesstore.demo.models.dto.BreadDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {

    private final BreadsDAO breadsDAO;

    public ProductService(BreadsDAO breadsDAO) {
        this.breadsDAO = breadsDAO;
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

     //   for(int i= 0; i < getBreads().size(); i++)
       for(Bread breads: getAllBreads())
            products.add(breads);

        for (Drink drinks: getDrinks())
            products.add(drinks);

        for (Fruit fruits: getFruits())
            products.add(fruits);

        for (Vegetable vegetables: getVegetables())
            products.add(vegetables);

        return products;
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

    public List<Bread> getAllBreads() {
        List<Bread> breads = new ArrayList<>();
        for( BreadDTO breadDTO : breadsDAO.getAllBreads()) {
            Bread bread = mapToBread(breadDTO);
            breads.add(bread);
        }
        return breads;
    }

    public void addBread(Bread bread) {
         breadsDAO.addBread(mapFromBread(bread));
    }

    public Bread getBreadById(Integer id) {
        if (breadsDAO.findBreadById(id).isPresent()) {
            return mapToBread(breadsDAO.findBreadById(id).get());
        }
        return null;
    }

    public void deleteBread (Integer id ) {
        breadsDAO.deleteBread(id);
    }

    private BreadDTO mapFromBread (Bread bread) {
        return new BreadDTO(bread.getName(), bread.getPrice());
    }

    private Bread mapToBread (BreadDTO breadDTO) {
        return new Bread(breadDTO.getId(), breadDTO.getName(), breadDTO.getPrice());
    }
}

