package se.groceriesstore.demo.repository.BreadsRepository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.BreadsDTO.ToastDTO;

public interface ToastRepository extends CrudRepository<ToastDTO, Integer> {
}
