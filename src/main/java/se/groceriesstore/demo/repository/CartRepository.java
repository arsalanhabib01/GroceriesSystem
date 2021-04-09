package se.groceriesstore.demo.repository;
import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.CartDTO;


public interface CartRepository extends CrudRepository<CartDTO, Integer> {

}
