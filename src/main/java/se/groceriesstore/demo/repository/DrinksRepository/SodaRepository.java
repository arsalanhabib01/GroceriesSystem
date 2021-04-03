package se.groceriesstore.demo.repository.DrinksRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.DrinksDTO.SodaDTO;


public interface SodaRepository extends CrudRepository<SodaDTO, Integer> {
}
