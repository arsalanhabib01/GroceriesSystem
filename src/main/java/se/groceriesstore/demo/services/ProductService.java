package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.BreadsDAO;
import se.groceriesstore.demo.dao.DrinksDAO;
import se.groceriesstore.demo.dao.VegetablesDAO;
import se.groceriesstore.demo.models.*;
import se.groceriesstore.demo.models.dto.BreadDTO;
import se.groceriesstore.demo.models.dto.DrinkDTO;
import se.groceriesstore.demo.models.dto.VegetableDTO;

import java.util.ArrayList;
import java.util.List;



@Service
public class ProductService {

    private final BreadsDAO breadsDAO;
    private final DrinksDAO drinksDAO;
    private final VegetablesDAO vegetablesDAO;

    public ProductService(BreadsDAO breadsDAO, DrinksDAO drinksDAO,
                          VegetablesDAO vegetablesDAO) {
        this.breadsDAO = breadsDAO;
        this.drinksDAO = drinksDAO;
        this.vegetablesDAO = vegetablesDAO;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        //   for(int i= 0; i < getBreads().size(); i++)
        for (Bread breads : getAllBreads())
            products.add(breads);

        for (Drink drinks : getAllDrinks())
            products.add(drinks);

        for (Fruit fruits : getFruits())
            products.add(fruits);

        for (Vegetable vegetables : getAllVegetables())
            products.add(vegetables);

        return products;
    }

    public List<Fruit> getFruits() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Äpple", 12));
        fruits.add(new Fruit("Orange", 23));
        fruits.add(new Fruit("Mango", 35));
        return fruits;
    }

    public List<Vegetable> getAllVegetables() {
        List<Vegetable> vegetables = new ArrayList<>();
        for (VegetableDTO vegetableDTO : vegetablesDAO.getAllVegetables()) {
            Vegetable vegetable = mapToVegetable(vegetableDTO);
            vegetables.add(vegetable);
        }
        return vegetables;
    }

    public void addVegetable(Vegetable vegetable) {
        vegetablesDAO.addVegetable(mapFromVegetable(vegetable));
    }

    public Vegetable getVegetableById(Integer id) {
        if (vegetablesDAO.findVegetableById(id).isPresent()) {
            return mapToVegetable(vegetablesDAO.findVegetableById(id).get());
        }
        return null;
    }

    public void deleteVegetable(Integer id) {
        vegetablesDAO.deleteVegetable(id);
    }

    private VegetableDTO mapFromVegetable(Vegetable vegetable) {
        return new VegetableDTO(vegetable.getName(), vegetable.getPrice());
    }

    private Vegetable mapToVegetable(VegetableDTO vegetableDTO) {
        return new Vegetable(vegetableDTO.getId(), vegetableDTO.getName(), vegetableDTO.getPrice());
    }

    public List<Drink> getAllDrinks() {
        List<Drink> drinks = new ArrayList<>();
        for (DrinkDTO drinkDTO : drinksDAO.getAllDrinks()) {
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

    public void deleteDrink(Integer id) {
        drinksDAO.deleteDrink(id);
    }

    private DrinkDTO mapFromDrink(Drink drink) {
        return new DrinkDTO(drink.getName(), drink.getPrice());
    }

    private Drink mapToDrink(DrinkDTO drinkDTO) {
        return new Drink(drinkDTO.getId(), drinkDTO.getName(), drinkDTO.getPrice());
    }


    public List<Bread> getAllBreads() {
        List<Bread> breads = new ArrayList<>();
        for (BreadDTO breadDTO : breadsDAO.getAllBreads()) {
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


    public Bread updateBread (Integer id, Integer price ) {
        Bread breadToUpdate = getBreadById(id);

        if (breadToUpdate != null ) {
             breadToUpdate.setName(breadToUpdate.getName());
             breadToUpdate.setPrice(breadToUpdate.getPrice());
        } else {
            breadToUpdate.setId(id); // TODO: Kan behöva sätta alla värden!
        }

        BreadDTO updateBreadDTO = breadsDAO.addBread(mapFromBread(breadToUpdate));
        return breadToUpdate;
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

