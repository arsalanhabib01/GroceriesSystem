package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.*;
import se.groceriesstore.demo.models.*;
import se.groceriesstore.demo.models.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        allDrinks.add(new DrinkDTO(1, 14, "Mellanmjölk"));
        allDrinks.add(new DrinkDTO(2, 35, "Äpplejuice"));
        allDrinks.add(new DrinkDTO(3, 13, "Trocadero"));

        allVegetables = new ArrayList<>();
        allVegetables.add(new VegetableDTO(1, 8, "Gurka"));
        allVegetables.add(new VegetableDTO(2, 15, "Broccoli"));
        allVegetables.add(new VegetableDTO(3, 13, "Avokado"));

        allFruits = new ArrayList<>();
        allFruits.add(new FruitDTO(1, 35, "Gröna druvor"));
        allFruits.add(new FruitDTO(2, 13, "Citron"));
        allFruits.add(new FruitDTO(3, 18, "Mango"));
    }

    @Test
    void getAllFruits_ShouldReturnAllFruits() {
        List<Fruit> expectedFruits = new ArrayList<>();
        expectedFruits.add(new Fruit(1, "Gröna druvor", 35));
        expectedFruits.add(new Fruit(2, "Citron",13));
        expectedFruits.add(new Fruit(3, "Mango", 18));

        Mockito.when(fruitsDAO.getAllFruits()).thenReturn(allFruits);
        List<Fruit> actualFruits = productService.getAllFruits();

        Assertions.assertThat(actualFruits.size()).isEqualTo(expectedFruits.size());
    }

    @Test
    void getAllVegetables_ShouldReturnAllVegetables() {
        List<Vegetable> expectedVegetables = new ArrayList<>();
        expectedVegetables.add(new Vegetable(1, "Gurka", 8));
        expectedVegetables.add(new Vegetable(2, "Broccoli",15));
        expectedVegetables.add(new Vegetable(3, "Avokado", 13));

        Mockito.when(vegetablesDAO.getAllVegetables()).thenReturn(allVegetables);
        List<Vegetable> actualVegetables = productService.getAllVegetables();

        Assertions.assertThat(actualVegetables.size()).isEqualTo(expectedVegetables.size());
    }

    @Test
    void getAllDrinks_ShouldReturnAllDrinks() {
        List<Drink> expectedDrinks = new ArrayList<>();
        expectedDrinks.add(new Drink(1, "Mellanmjölk", 14));
        expectedDrinks.add(new Drink(2, "Äpplejuice",35));
        expectedDrinks.add(new Drink(3, "Trocadero", 13));

        Mockito.when(drinksDAO.getAllDrinks()).thenReturn(allDrinks);
        List<Drink> actualDrinks = productService.getAllDrinks();

        Assertions.assertThat(actualDrinks.size()).isEqualTo(expectedDrinks.size());
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
    void addFruit_ShouldAddFruitAndReturnCorrectName() {
        FruitDTO fruitDTOFromDatabase = new FruitDTO("Gröna druvor", 35);
        Fruit newFruit = new Fruit(null, "Gröna druvor", 35);

        Mockito.when(fruitsDAO.addFruit(ArgumentMatchers.any(FruitDTO.class))).thenReturn(fruitDTOFromDatabase);
        Fruit createdFruit = productService.addFruit(newFruit);

        Assertions.assertThat(newFruit.getName()).isEqualTo(createdFruit.getName());
    }

    @Test
    void addVegetable_ShouldAddVegetableAndReturnCorrectName() {
        VegetableDTO vegetableDTOFromDatabase = new VegetableDTO("Gurka", 8);
        Vegetable newVegetable = new Vegetable(null, "Gurka", 8);

        Mockito.when(vegetablesDAO.addVegetable(ArgumentMatchers.any(VegetableDTO.class))).thenReturn(vegetableDTOFromDatabase);
        Vegetable createdVegetable = productService.addVegetable(newVegetable);

        Assertions.assertThat(newVegetable.getName()).isEqualTo(createdVegetable.getName());
    }

    @Test
    void addDrink_ShouldAddDrinkAndReturnCorrectName() {
        DrinkDTO drinkDTOFromDatabase = new DrinkDTO("Mellanmjölk", 14);
        Drink newDrink = new Drink(null, "Mellanmjölk", 14);

        Mockito.when(drinksDAO.addDrink(ArgumentMatchers.any(DrinkDTO.class))).thenReturn(drinkDTOFromDatabase);
        Drink createdDrink = productService.addDrink(newDrink);

        Assertions.assertThat(newDrink.getName()).isEqualTo(createdDrink.getName());
    }

    @Test
    void addBread_ShouldAddBreadAndReturnCorrectName() {
        BreadDTO breadDTOFromDatabase = new BreadDTO("Roast'n Toast", 24);
        Bread newBread = new Bread(null, "Roast'n Toast", 24);

        Mockito.when(breadsDAO.addBread(ArgumentMatchers.any(BreadDTO.class))).thenReturn(breadDTOFromDatabase);
        Bread createdBread = productService.addBread(newBread);

        Assertions.assertThat(newBread.getName()).isEqualTo(createdBread.getName());
    }

    @Test
    void getFruitById_ShouldFindFruitById() {
        FruitDTO fruitDTOFromDatabase = new FruitDTO(1, 35, "Gröna druvor");
        Fruit expectedFruit = new Fruit(1, "Gröna druvor", 35);

        Mockito.when(fruitsDAO.findFruitById(1)).thenReturn(Optional.of(fruitDTOFromDatabase));
        Fruit actualFruit = productService.getFruitById(1);

        Assertions.assertThat(actualFruit.getId()).isEqualTo(expectedFruit.getId());
    }

    @Test
    void getVegetableById_ShouldFindVegetableById() {
        VegetableDTO vegetableDTOFromDatabase = new VegetableDTO(1, 8, "Gurka");
        Vegetable expectedVegetable = new Vegetable(1, "Gurka", 8);

        Mockito.when(vegetablesDAO.findVegetableById(1)).thenReturn(Optional.of(vegetableDTOFromDatabase));
        Vegetable actualVegetable = productService.getVegetableById(1);

        Assertions.assertThat(actualVegetable.getId()).isEqualTo(expectedVegetable.getId());
    }

    @Test
    void getDrinkById_ShouldFindDrinkById() {
        DrinkDTO drinkDTOFromDatabase = new DrinkDTO(1, 14, "Mellanmjölk");
        Drink expectedDrink = new Drink(1, "Mellanmjölk", 14);

        Mockito.when(drinksDAO.findDrinkById(1)).thenReturn(Optional.of(drinkDTOFromDatabase));
        Drink actualDrink = productService.getDrinkById(1);

        Assertions.assertThat(actualDrink.getId()).isEqualTo(expectedDrink.getId());
    }

    @Test
    void getBreadById_ShouldFindBreadById() {
        BreadDTO breadDTOFromDatabase = new BreadDTO(1, 24, "Roast'n Toast");
        Bread expectedBread = new Bread(1, "Roast'n Toast", 24);

        Mockito.when(breadsDAO.findBreadById(1)).thenReturn(Optional.of(breadDTOFromDatabase));
        Bread actualBread = productService.getBreadById(1);

        Assertions.assertThat(actualBread.getId()).isEqualTo(expectedBread.getId());
    }

    @Test
    void getBreadById_ShouldFindBreadWithCorrectName() {
        BreadDTO breadDTOFromDatabase = new BreadDTO(1, 24, "Roast'n Toast");
        Bread expectedBread = new Bread(1, "Roast'n Toast", 24);

        Mockito.when(breadsDAO.findBreadById(1)).thenReturn(Optional.of(breadDTOFromDatabase));
        Bread actualBread = productService.getBreadById(1);

        Assertions.assertThat(actualBread.getName()).isEqualTo(expectedBread.getName());
    }

    @Test
    void deleteFruit_ShouldInvokeDeleteFruit() {
        productService.deleteFruit(1);
        Mockito.verify(fruitsDAO, Mockito.times(1)).deleteFruit(1);
    }

    @Test
    void deleteFruit_ShouldNotInvokeAddFruit() {
        productService.deleteFruit(1);
        Mockito.verify(fruitsDAO, Mockito.times(0)).addFruit(new FruitDTO(null, 1, null));
    }

    @Test
    void deleteVegetable_ShouldInvokeDeleteVegetable() {
        productService.deleteVegetable(1);
        Mockito.verify(vegetablesDAO, Mockito.times(1)).deleteVegetable(1);
    }

    @Test
    void deleteVegetable_ShouldNotInvokeAddVegetable() {
        productService.deleteVegetable(1);
        Mockito.verify(vegetablesDAO, Mockito.times(0)).addVegetable(new VegetableDTO(null, 1, null));
    }

    @Test
    void deleteDrink_ShouldInvokeDeleteDrink() {
        productService.deleteDrink(1);
        Mockito.verify(drinksDAO, Mockito.times(1)).deleteDrink(1);
    }

    @Test
    void deleteDrink_ShouldNotInvokeAddDrink() {
        productService.deleteDrink(1);
        Mockito.verify(drinksDAO, Mockito.times(0)).addDrink(new DrinkDTO(null, 1, null));
    }

    @Test
    void deleteBread_ShouldInvokeDeleteBread() {
        productService.deleteBread(1);
        Mockito.verify(breadsDAO, Mockito.times(1)).deleteBread(1);
    }

    @Test
    void deleteBread_ShouldNotInvokeAddBread() {
        productService.deleteBread(1);
        Mockito.verify(breadsDAO, Mockito.times(0)).addBread(new BreadDTO(null, 1, null));
    }
}