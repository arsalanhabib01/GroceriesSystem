package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.BreadsDAO;
import se.groceriesstore.demo.dao.DrinksDAO;
import se.groceriesstore.demo.models.*;
import se.groceriesstore.demo.models.dto.BreadDTO;
import se.groceriesstore.demo.models.dto.DrinkDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {

    private final BreadsDAO breadsDAO;
    private final DrinksDAO drinksDAO;

    public ProductService(BreadsDAO breadsDAO, DrinksDAO drinksDAO) {
        this.breadsDAO = breadsDAO;
        this.drinksDAO = drinksDAO;
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

     //   for(int i= 0; i < getBreads().size(); i++)
       for(Bread breads: getAllBreads())
            products.add(breads);

        for (Drink drinks: getAllDrinks())
            products.add(drinks);

        for (Fruit fruits: getFruits())
            products.add(fruits);

        for (Vegetable vegetables: getVegetables())
            products.add(vegetables);

        return products;
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

    public List<Drink> getAllDrinks(){
        List<Drink> drinks = new ArrayList<>();
        for (DrinkDTO drinkDTO : drinksDAO.getAllDrinks()){
            Drink drink = mapToDrink(drinkDTO);
            drinks.add(drink);
        }
        return drinks;
    }

    public void addDrink(Drink drink) {
        drinksDAO.addDrink(mapFromDrink(drink));
    }

    public Drink getDrinkById(Integer id) {
        if (drinksDAO.findDrinkById(id).isPresent()) {
            return mapToDrink(drinksDAO.findDrinkById(id).get());
        }
        return null;
    }

    public void deleteDrink (Integer id ) {
        drinksDAO.deleteDrink(id);
    }


    private DrinkDTO mapFromDrink (Drink drink) {
        return new DrinkDTO(drink.getName(), drink.getPrice());
    }

    private Drink mapToDrink (DrinkDTO drinkDTO) {
        return new Drink(drinkDTO.getId(), drinkDTO.getName(), drinkDTO.getPrice());
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

