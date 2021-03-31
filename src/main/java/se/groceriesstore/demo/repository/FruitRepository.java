package se.groceriesstore.demo.repository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.FruitDTO;

public interface FruitRepository extends CrudRepository<FruitDTO,Integer> {
}
