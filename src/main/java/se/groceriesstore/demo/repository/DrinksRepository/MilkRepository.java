package se.groceriesstore.demo.repository.DrinksRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.DrinksDTO.MilkDTO;

public interface MilkRepository extends CrudRepository<MilkDTO, Integer> {
}
