package se.groceriesstore.demo.repository.DrinksRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.DrinksDTO.KaffeDTO;

public interface KaffeRepository extends CrudRepository<KaffeDTO, Integer> {
}
