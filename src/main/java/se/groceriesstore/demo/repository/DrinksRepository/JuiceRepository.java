package se.groceriesstore.demo.repository.DrinksRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.DrinksDTO.JuiceDTO;

public interface JuiceRepository extends CrudRepository<JuiceDTO, Integer> {
}
