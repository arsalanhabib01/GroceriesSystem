package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.*;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.models.dto.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    public static BreadsDAO breadsDAO;
    public static DrinksDAO drinksDAO;
    public static VegetablesDAO vegetablesDAO;
    public static FruitsDAO fruitsDAO;
    public static CartDAO cartDAO;

    public ProductService productService;

    public List<BreadDTO> allBreads;
    public List<DrinkDTO> allDrinks;
    public List<VegetableDTO> allVegetables;
    public List<FruitDTO> allFruits;
    public List<CartDTO> allCarts;

    @BeforeAll
    public static void initAll() {
        breadsDAO = Mockito.mock(BreadsDAO.class);
        drinksDAO = Mockito.mock(DrinksDAO.class);
        vegetablesDAO = Mockito.mock(VegetablesDAO.class);
        fruitsDAO = Mockito.mock(FruitsDAO.class);
        cartDAO = Mockito.mock(CartDAO.class);
    }

    @BeforeEach
    public void init() {
        productService = new ProductService(breadsDAO, drinksDAO, vegetablesDAO, fruitsDAO, cartDAO);

        allBreads = new ArrayList<>();
        allBreads.add(new BreadDTO(1, 24, "Roast'n Toast"));
        allBreads.add(new BreadDTO(2, 17, "Rosta!"));
        allBreads.add(new BreadDTO(3, 26, "Jättefranska"));

        allDrinks = new ArrayList<>();
        allVegetables = new ArrayList<>();
        allFruits = new ArrayList<>();
        allCarts = new ArrayList<>();
    }

    @Test
    void getCart() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void getAllFruits() {
    }

    @Test
    void getAllVegetables() {
    }

    @Test
    void getAllDrinks() {
    }

    @Test
    void getAllBreads_ShouldReturnAllBreads() {
        List<Bread> expectedBreads = new ArrayList<>();
        expectedBreads.add(new Bread(1, "Roast'n Toast", 24));
        expectedBreads.add(new Bread(2, "Rosta!",17));
        expectedBreads.add(new Bread(3, "Jättefranska", 26));

        Mockito.when(breadsDAO.getAllBreads()).thenReturn(allBreads);
        List<Bread> actualBreads = productService.getAllBreads();

        Assertions.assertThat(actualBreads.size()).isEqualTo(expectedBreads.size());
    }

    @Test
    void addFruit() {
    }

    @Test
    void addVegetable() {
    }

    @Test
    void addDrink() {
    }

    @Test
    void addBread() {
    }

    @Test
    void getFruitById() {
    }

    @Test
    void getVegetableById() {
    }

    @Test
    void getDrinkById() {
    }

    @Test
    void getBreadById() {
    }

    @Test
    void deleteFruit() {
    }

    @Test
    void deleteVegetable() {
    }

    @Test
    void deleteDrink() {
    }

    @Test
    void deleteBread() {
    }
}