package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.DrinkDAO.JuicesDAO;
import se.groceriesstore.demo.dao.DrinkDAO.KaffesDAO;
import se.groceriesstore.demo.dao.DrinkDAO.MilksDAO;
import se.groceriesstore.demo.dao.DrinkDAO.SodasDAO;
import se.groceriesstore.demo.models.Drink;
import se.groceriesstore.demo.models.Drinks.Juice;
import se.groceriesstore.demo.models.Drinks.Kaffe;
import se.groceriesstore.demo.models.Drinks.Milk;
import se.groceriesstore.demo.models.Drinks.Soda;
import se.groceriesstore.demo.models.dto.DrinksDTO.JuiceDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.KaffeDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.MilkDTO;
import se.groceriesstore.demo.models.dto.DrinksDTO.SodaDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkService {

    private final KaffesDAO kaffesDAO;
    private final MilksDAO milksDAO;
    private final SodasDAO sodasDAO;
    private final JuicesDAO juicesDAO;

    public DrinkService(KaffesDAO kaffesDAO, MilksDAO milksDAO,
                        SodasDAO sodasDAO, JuicesDAO juicesDAO) {
        this.kaffesDAO = kaffesDAO;
        this.milksDAO = milksDAO;
        this.sodasDAO = sodasDAO;
        this.juicesDAO = juicesDAO;
    }

    public List<Drink> getDrinks() {
        List<Drink> drinks = new ArrayList<>();

        //   for(int i= 0; i < getBreads().size(); i++)
        for (Kaffe kaffes : getAllKaffes())
            drinks.add(kaffes);

        for (Milk milks : getAllMilks())
            drinks.add(milks);

        for (Soda sodas : getAllSodas())
            drinks.add(sodas);

        for (Juice juices : getAllJuices())
            drinks.add(juices);


        return drinks;
    }

    public List<Kaffe> getAllKaffes(){
        List<Kaffe> kaffes = new ArrayList<>();
        for (KaffeDTO kaffeDTO: kaffesDAO.getAllKaffes()){
            Kaffe kaffe = mapToKaffe(kaffeDTO);
            kaffes.add(kaffe);
        }
        return kaffes;
    }

    public List<Milk> getAllMilks(){
        List<Milk> milks = new ArrayList<>();
        for (MilkDTO milkDTO: milksDAO.getAllMilks()){
            Milk milk = mapToMilk(milkDTO);
            milks.add(milk);
        }
        return milks;
    }

    public List<Soda> getAllSodas(){
        List<Soda> sodas = new ArrayList<>();
        for (SodaDTO sodaDTO: sodasDAO.getAllSodas()){
            Soda soda = mapToSoda(sodaDTO);
            sodas.add(soda);
        }
        return sodas;
    }

    public List<Juice> getAllJuices(){
        List<Juice> juices = new ArrayList<>();
        for (JuiceDTO juiceDTO: juicesDAO.getAllJuices()){
            Juice juice = mapToJuice(juiceDTO);
            juices.add(juice);
        }
        return juices;
    }

    public Kaffe addKaffe(Kaffe kaffe) {
        KaffeDTO newKaffeDTO = kaffesDAO.addKaffe(mapFromKaffe(kaffe));
        return mapToKaffe(newKaffeDTO);
    }

    public void addMilk(Milk milk) {
        milksDAO.addMilk(mapFromMilk(milk));
    }

    public void addSoda(Soda soda) {
        sodasDAO.addSoda(mapFromSoda(soda));
    }

    public void addJuice(Juice juice) {
        juicesDAO.addJuice(mapFromJuice(juice));
    }


    public Kaffe getKaffeById(Integer id) {
        if (kaffesDAO.findKaffeById(id).isPresent()) {
            return mapToKaffe(kaffesDAO.findKaffeById(id).get());
        }
        return null;
    }

    public Milk getMilkById(Integer id) {
        if (milksDAO.findMilkById(id).isPresent()) {
            return mapToMilk(milksDAO.findMilkById(id).get());
        }
        return null;
    }

    public Soda getSodaById(Integer id) {
        if (sodasDAO.findSodaById(id).isPresent()) {
            return mapToSoda(sodasDAO.findSodaById(id).get());
        }
        return null;
    }

    public Juice getJuiceById(Integer id) {
        if (juicesDAO.findJuiceById(id).isPresent()) {
            return mapToJuice(juicesDAO.findJuiceById(id).get());
        }
        return null;
    }


    public void deleteKaffe (Integer id ) {
        kaffesDAO.deleteKaffe(id);
    }

    public void deleteMilk (Integer id ) {
        milksDAO.deleteMilk(id);
    }

    public void deleteSoda (Integer id ) {
        sodasDAO.deleteSoda(id);
    }

    public void deleteJuice (Integer id ) {
        juicesDAO.deleteJuice(id);
    }


    private KaffeDTO mapFromKaffe (Kaffe kaffe) {
        return new KaffeDTO(kaffe.getName(), kaffe.getPrice(), kaffe.getImage(), kaffe.getVolume());
    }

    private MilkDTO mapFromMilk (Milk milk) {
        return new MilkDTO(milk.getName(), milk.getPrice(), milk.getImage(), milk.getVolume());
    }

    private SodaDTO mapFromSoda (Soda soda) {
        return new SodaDTO(soda.getName(), soda.getPrice(), soda.getImage(), soda.getVolume());
    }

    private JuiceDTO mapFromJuice (Juice juice) {
        return new JuiceDTO(juice.getName(), juice.getPrice(), juice.getImage(), juice.getVolume());
    }


    private Kaffe mapToKaffe (KaffeDTO kaffeDTO) {
        return new Kaffe(kaffeDTO.getId(), kaffeDTO.getName(), kaffeDTO.getPrice(), kaffeDTO.getImage(), kaffeDTO.getVolume());
    }

    private Milk mapToMilk (MilkDTO milkDTO) {
        return new Milk(milkDTO.getId(), milkDTO.getName(), milkDTO.getPrice(), milkDTO.getImage(), milkDTO.getVolume());
    }

    private Soda mapToSoda (SodaDTO sodaDTO) {
        return new Soda(sodaDTO.getId(), sodaDTO.getName(), sodaDTO.getPrice(), sodaDTO.getImage(), sodaDTO.getVolume());
    }

    private Juice mapToJuice (JuiceDTO juiceDTO) {
        return new Juice(juiceDTO.getId(), juiceDTO.getName(), juiceDTO.getPrice(), juiceDTO.getImage() ,juiceDTO.getVolume());
    }

}
