package se.groceriesstore.demo.repository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.BreadDTO;

public interface BreadRepository extends CrudRepository <BreadDTO, Integer> {
}
