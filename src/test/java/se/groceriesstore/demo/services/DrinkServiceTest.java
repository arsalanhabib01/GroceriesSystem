
package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import se.groceriesstore.demo.dao.DrinkDAO.JuicesDAO;
import se.groceriesstore.demo.dao.DrinkDAO.KaffesDAO;
import se.groceriesstore.demo.dao.DrinkDAO.MilksDAO;
import se.groceriesstore.demo.dao.DrinkDAO.SodasDAO;
import se.groceriesstore.demo.dao.DrinksDAO;
import se.groceriesstore.demo.models.Drinks.Juice;
import se.groceriesstore.demo.models.Drinks.Kaffe;
import se.groceriesstore.demo.models.dto.DrinksDTO.JuiceDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.KaffeDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.MilkDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.SodaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DrinkServiceTest {

    public static DrinksDAO drinksDAO;
    public static KaffesDAO kaffesDAO;
    public static MilksDAO milkDAO;
    public static SodasDAO sodasDAO;
    public static JuicesDAO juicesDAO;

    public DrinkService drinkService;
    public List<KaffeDTO> allKaffe;
    public List<JuiceDTO> allJuice;


    @BeforeAll
    public static void initAll(){
        drinksDAO = Mockito.mock(DrinksDAO.class);
        kaffesDAO = Mockito.mock(KaffesDAO.class);
        milkDAO = Mockito.mock(MilksDAO.class);
        sodasDAO = Mockito.mock(SodasDAO.class);
        juicesDAO = Mockito.mock(JuicesDAO.class);
    }

    @BeforeEach
    public void init(){
        drinkService = new DrinkService(kaffesDAO, milkDAO,sodasDAO, juicesDAO);
        allKaffe = new ArrayList<>();
        allKaffe.add(new KaffeDTO("Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g"));
        allKaffe.add(new KaffeDTO("Mörk Rost",50,"image/drinks/kaffes/Mörkrost.jpg", "200g"));

        allJuice = new ArrayList<>();
        allJuice.add(new JuiceDTO("Apelsin Juice",29,"image/drinks/juices/Aplesin-Juice.jpg","250 ml"));
        allJuice.add(new JuiceDTO("Multivitamin",35,"image/drinks/juices/Multivitamin.jpg","500 ml"));

    }

    @Test
    void getAllKaffes_ShouldReturnKaffes() {
        List<Kaffe> expectedKaffes = new ArrayList<>();
        expectedKaffes.add(new Kaffe(1,"Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g"));
        expectedKaffes.add(new Kaffe(2,"Mörk Rost",50,"image/drinks/kaffes/Mörkrost.jpg", "200g"));

        Mockito.when(kaffesDAO.getAllKaffes()).thenReturn(allKaffe);
        List<Kaffe> actualKaffe = drinkService.getAllKaffes();

        Assertions.assertThat(actualKaffe.size()).isEqualTo(expectedKaffes.size());
    }


    @Test
    void addKaffe_ShouldAddKaffeAndReturnCorrectId() {
        KaffeDTO kaffeDTOFromDB = new KaffeDTO(1, 65,"Mellan Rost", "image/drinks/kaffes/mellanrost.jpg","470g");
        Kaffe newKaffe = new Kaffe(1,"Mellan Rost",65,"image/drinks/kaffes/mellanrost.jpg","470g");

        Mockito.when(kaffesDAO.addKaffe(ArgumentMatchers.any(KaffeDTO.class))).thenReturn(kaffeDTOFromDB);
        Kaffe createdKaffe = drinkService.addKaffe(newKaffe);

        Assertions.assertThat(newKaffe.getId()).isEqualTo(createdKaffe.getId());
    }
    @Test
    void addJuice() {


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
    void getAllJuices_ShouldReturnJuices() {
        List<Juice> expectedJuices = new ArrayList<>();
        expectedJuices.add(new Juice(1,"Apelsin Juice",29,"image/drinks/juices/Aplesin-Juice.jpg","250 ml"));
        expectedJuices.add(new Juice(2,"Multivitamin",35,"image/drinks/juices/Multivitamin.jpg","500 ml"));

        Mockito.when(juicesDAO.getAllJuices()).thenReturn(allJuice);
        List<Juice> actualJuice = drinkService.getAllJuices();
        Assertions.assertThat(actualJuice.size()).isEqualTo(expectedJuices.size());
    }
    @Test
    void getJuiceByI_ShouldReturnSameId() {

        JuiceDTO juiceDTOFromBD = new JuiceDTO(1,29,"Apelsin Juice");
        Juice expectedJuice = new Juice(1,29,"Apelsin Juice");
        Mockito.when(juicesDAO.findJuiceById(1)).thenReturn(Optional.of(juiceDTOFromBD));
        Juice actualJuice = drinkService.getJuiceById(1);
        Assertions.assertThat(actualJuice.getId()).isEqualTo(expectedJuice.getId());
    }

    @Test
    void addMilk() {
    }





    @Test
    void getKaffeById_ShouldReturnSameId() {
        KaffeDTO kaffeDTOfromDB = new KaffeDTO(1, 32, "Arvid Nordqvist");
        Kaffe expectedKaffe = new Kaffe(1 , 32, "Arvid Nordqvist");

        Mockito.when(kaffesDAO.findKaffeById(1)).thenReturn(Optional.of(kaffeDTOfromDB));

        Kaffe actualKaffe = drinkService.getKaffeById(1);

        Assertions.assertThat(actualKaffe.getId()).isEqualTo(expectedKaffe.getId());

    }



    @Test
    void getMilkById() {
    }

    @Test
    void getSodaById() {
    }


    @Test
    void deleteKaffe_ShouldInvokeDeleteKaffe() {
        drinkService.deleteKaffe(2);
        Mockito.verify(kaffesDAO, Mockito.times(1)).deleteKaffe(2);
    }

    @Test
    void deleteKaffe_ShouldNotInvokeAddKaffe() {
        drinkService.deleteKaffe(1);
        Mockito.verify(kaffesDAO, Mockito.times(0)).addKaffe(new KaffeDTO(1, 40, "Skånerost Mörkrost Bryggkaffe", "image/drinks/kaffes/Skanerost-morkrost-bryggkaffe.jpg", "450G"));
    }

    @Test
    void deleteMilk_ShouldInvokeDeleteMilk() {
        drinkService.deleteMilk(2);
        Mockito.verify(milkDAO, Mockito.times(1)).deleteMilk(2);
    }

    @Test
    void deleteMilk_ShouldNotInvokeAddMilk() {
        drinkService.deleteMilk(1);
        Mockito.verify(milkDAO, Mockito.times(0)).addMilk(new MilkDTO(1, 24, "Getmjölk", "image/drinks/milks/Getmjolk.jpg", "1L"));
    }

    @Test
    void deleteSoda_ShouldInvokeDeleteSoda() {
        drinkService.deleteSoda(2);
        Mockito.verify(sodasDAO, Mockito.times(1)).deleteSoda(2);
    }

    @Test
    void deleteSoda_ShouldNotInvokeAddSoda() {
        drinkService.deleteSoda(1);
        Mockito.verify(sodasDAO, Mockito.times(0)).addSoda(new SodaDTO(1, 10, "Hallonsoda", "image/drinks/sodas/Hallonsoda.jpg", "1.5L"));
    }

    @Test
    void deleteJuice_ShouldInvokeDeleteJuice() {
        drinkService.deleteJuice(2);
        Mockito.verify(juicesDAO, Mockito.times(1)).deleteJuice(2);
    }

    @Test
    void deleteJuice_ShouldNotInvokeAddJuice() {
        drinkService.deleteJuice(1);
        Mockito.verify(juicesDAO, Mockito.times(0)).addJuice(new JuiceDTO(1, 14, "Fruktdryck Päron", "image/drinks/juices/Fruktdryck-paron.jpg", "1.5L"));
    }
}



