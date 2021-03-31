package se.groceriesstore.demo.repository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.DrinkDTO;

public interface DrinkRepository extends CrudRepository <DrinkDTO, Integer> {
}
