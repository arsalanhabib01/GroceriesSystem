
package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.groceriesstore.demo.dao.DrinkDAO.KaffesDAO;
import se.groceriesstore.demo.dao.DrinksDAO;
import se.groceriesstore.demo.models.Drinks.Kaffe;
import se.groceriesstore.demo.models.dto.DrinksDTO.KaffeDTO;

import java.util.ArrayList;
import java.util.List;

class DrinkServiceTest {

    public static DrinksDAO drinksDAO;
    public static KaffesDAO kaffesDAO;
    public DrinkService drinkService;
    public List<KaffeDTO> allKaffe;


    @BeforeAll
    public static void initAll(){drinksDAO = Mockito.mock(DrinksDAO.class);}
    @BeforeEach
    public void init(){
        allKaffe = new ArrayList<>();
        allKaffe = new ArrayList<>();
        allKaffe.add(new KaffeDTO("Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g"));
        allKaffe.add(new KaffeDTO("Mörk Rost",50,"image/drinks/kaffes/Mörkrost.jpg", "200g"));
    }

    @Test
    void getAllKaffes_ShouldReturnKaffes() {
        List<Kaffe> expectedKaffes = new ArrayList<>();
        expectedKaffes.add(new Kaffe(1,"Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g"));
        expectedKaffes.add(new Kaffe(2,"Mörk Rost",50,"image/drinks/kaffes/Mörkrost.jpg", "200g"));
        Mockito.when(kaffesDAO.getAllKaffes()).thenReturn(allKaffe);
        List<Kaffe> actualKaffe = drinkService.getAllKaffes();
        Assertions.assertThat(actualKaffe.size()).isEqualTo(expectedKaffes);
    }
    @Test
    void addKaffe_ShouldAddKaffeAndReturnCorrectId() {
        KaffeDTO kaffeDTOFromBD = new KaffeDTO("Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g");
        Kaffe newKaffe = new Kaffe(1,"Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g");
        Mockito.when(drinksDAO.addDrink(ArgumentMatchers.any(DrinkDTO.class))).thenReturn(kaffeDTOFromBD);
        Kaffe createKaffe = drinkService.addKaffe(newKaffe);
        Assertions.assertThat(newKaffe.getId()).isEqualTo(createKaffe.getId());
    }
  @Test
    void getDrinks() {
    }

    @Test
    void getAllMilks() {
    }

    @Test
    void getAllSodas() {
    }

    @Test
    void getAllJuices() {
    }



    @Test
    void addMilk() {
    }

    @Test
    void addSoda() {
    }

    @Test
    void addJuice() {
    }

    @Test
    void getKaffeById() {
    }

    @Test
    void getMilkById() {
    }

    @Test
    void getSodaById() {
    }

    @Test
    void getJuiceById() {
    }

    @Test
    void deleteKaffe() {
    }

    @Test
    void deleteMilk() {
    }

    @Test
    void deleteSoda() {
    }

    @Test
    void deleteJuice() {
    }



}



