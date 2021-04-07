package se.groceriesstore.demo.repository.BreadsRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.BreadsDTO.BaguetteDTO;

public interface BaguetteRepository extends CrudRepository<BaguetteDTO, Integer> {
}
