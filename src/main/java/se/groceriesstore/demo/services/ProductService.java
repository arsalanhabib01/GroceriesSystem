package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.*;
import se.groceriesstore.demo.models.*;
import se.groceriesstore.demo.models.dto.*;

import java.util.ArrayList;
import java.util.List;



@Service
public class ProductService {

    private final BreadsDAO breadsDAO;
    private final DrinksDAO drinksDAO;
    private final VegetablesDAO vegetablesDAO;
    private final FruitsDAO fruitsDAO;
    private final CartDAO cartDAO;

    public ProductService(BreadsDAO breadsDAO, DrinksDAO drinksDAO,
                          VegetablesDAO vegetablesDAO, FruitsDAO fruitsDAO, CartDAO cartDAO) {
        this.breadsDAO = breadsDAO;
        this.drinksDAO = drinksDAO;
        this.vegetablesDAO = vegetablesDAO;
        this.fruitsDAO = fruitsDAO;
        this.cartDAO = cartDAO;
    }

    public List<Product> getCart() {
        List<Product> cart = new ArrayList<>();
        return cart;
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

     //   for(int i= 0; i < getBreads().size(); i++)
       for(Bread breads: getAllBreads())
            products.add(breads);

        for (Drink drinks: getAllDrinks())
            products.add(drinks);

        for (Fruit fruits: getAllFruits())
            products.add(fruits);

        for (Vegetable vegetables: getAllVegetables())
            products.add(vegetables);

        return products;
    }

    public List<Fruit> getAllFruits(){
        List<Fruit> fruits = new ArrayList<>();
        for (FruitDTO fruitDTO : fruitsDAO.getAllFruits()){
            Fruit fruit = mapToFruit(fruitDTO);
            fruits.add(fruit);
        }
        return fruits;
    }

    public List<Vegetable> getAllVegetables(){
        List<Vegetable> vegetables = new ArrayList<>();
        for (VegetableDTO vegetableDTO : vegetablesDAO.getAllVegetables()){
            Vegetable vegetable = mapToVegetable(vegetableDTO);
            vegetables.add(vegetable);
        }
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

    public List<Bread> getAllBreads() {
        List<Bread> breads = new ArrayList<>();
        for( BreadDTO breadDTO : breadsDAO.getAllBreads()) {
            Bread bread = mapToBread(breadDTO);
            breads.add(bread);
        }
        return breads;
    }


    public void addFruit(Fruit fruit) {
        fruitsDAO.addFruit(mapFromFruit(fruit));
    }

    public void addVegetable(Vegetable vegetable) {
        vegetablesDAO.addVegetable(mapFromVegetable(vegetable));
    }

    public void addDrink(Drink drink) {
        drinksDAO.addDrink(mapFromDrink(drink));
    }

    public Bread addBread(Bread bread) {
        BreadDTO newBreadDTO = breadsDAO.addBread(mapFromBread(bread));
        return mapToBread(newBreadDTO);
    }

    public Fruit getFruitById(Integer id) {
        if (fruitsDAO.findFruitById(id).isPresent()) {
            return mapToFruit(fruitsDAO.findFruitById(id).get());
        }
        return null;
    }

    public Vegetable getVegetableById(Integer id) {
        if (vegetablesDAO.findVegetableById(id).isPresent()) {
            return mapToVegetable(vegetablesDAO.findVegetableById(id).get());
        }
        return null;
    }

    public Drink getDrinkById(Integer id) {
        if (drinksDAO.findDrinkById(id).isPresent()) {
            return mapToDrink(drinksDAO.findDrinkById(id).get());
        }
        return null;
    }

    public Bread getBreadById(Integer id) {
        if (breadsDAO.findBreadById(id).isPresent()) {
            return mapToBread(breadsDAO.findBreadById(id).get());
        }
        return null;
    }



    public void deleteFruit (Integer id ) {
        fruitsDAO.deleteFruit(id);
    }

    public void deleteVegetable (Integer id ) {
        vegetablesDAO.deleteVegetable(id);
    }

    public void deleteDrink (Integer id ) {
        drinksDAO.deleteDrink(id);
    }

    public void deleteBread (Integer id ) {
        breadsDAO.deleteBread(id);
    }


    private FruitDTO mapFromFruit (Fruit fruit) {
        return new FruitDTO(fruit.getName(), fruit.getPrice());
    }

    private VegetableDTO mapFromVegetable (Vegetable vegetable) {
        return new VegetableDTO(vegetable.getName(), vegetable.getPrice());
    }

    private DrinkDTO mapFromDrink (Drink drink) {
        return new DrinkDTO(drink.getName(), drink.getPrice());
    }

    private BreadDTO mapFromBread (Bread bread) {
        return new BreadDTO(bread.getName(), bread.getPrice());
    }


    private Fruit mapToFruit (FruitDTO fruitDTO) {
        return new Fruit(fruitDTO.getId(), fruitDTO.getName(), fruitDTO.getPrice());
    }

    private Vegetable mapToVegetable (VegetableDTO vegetableDTO) {
        return new Vegetable(vegetableDTO.getId(), vegetableDTO.getName(), vegetableDTO.getPrice());
    }

    private Drink mapToDrink (DrinkDTO drinkDTO) {
        return new Drink(drinkDTO.getId(), drinkDTO.getName(), drinkDTO.getPrice());
    }

    private Bread mapToBread (BreadDTO breadDTO) {
        return new Bread(breadDTO.getId(), breadDTO.getName(), breadDTO.getPrice());
    }


}

