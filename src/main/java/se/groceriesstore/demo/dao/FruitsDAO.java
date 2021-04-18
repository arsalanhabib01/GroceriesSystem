package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.Fruit;
import se.groceriesstore.demo.models.dto.FruitDTO;
import se.groceriesstore.demo.repository.FruitRepository;

import java.util.Optional;

@Repository
public class FruitsDAO {

    private final FruitRepository repositoryFruit;

    public FruitsDAO(FruitRepository repositoryFruit) {
        this.repositoryFruit = repositoryFruit;
    }

    public FruitDTO addFruit(FruitDTO fruitDTO) {
        return repositoryFruit.save(fruitDTO);
    }

    public Iterable<FruitDTO> getAllFruits() {
        return repositoryFruit.findAll();
    }

    public Optional<FruitDTO> findFruitById(Integer id) {
        return repositoryFruit.findById(id);

    }
    public void deleteFruit (Integer id) {
        repositoryFruit.deleteById(id);
    }

}
