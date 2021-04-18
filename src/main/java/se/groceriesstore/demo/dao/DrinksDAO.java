package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.DrinkDTO;
import se.groceriesstore.demo.repository.DrinkRepository;

import java.util.Optional;

@Repository
public class DrinksDAO {

    private final DrinkRepository repositoryDrink;

    public DrinksDAO(DrinkRepository repositoryDrink) {
        this.repositoryDrink = repositoryDrink;
    }

    public DrinkDTO addDrink(DrinkDTO drinkDTO) {
        return repositoryDrink.save(drinkDTO);
    }

    public Iterable<DrinkDTO> getAllDrinks() {
        return repositoryDrink.findAll();
    }

    public Optional<DrinkDTO> findDrinkById(Integer id) {
        return repositoryDrink.findById(id);

    }
    public void deleteDrink (Integer id) {
        repositoryDrink.deleteById(id);
    }

}
