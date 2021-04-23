package se.groceriesstore.demo.repository;
import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.CartDTO;
import se.groceriesstore.demo.models.dto.OrderDTO;


public interface OrderRepository extends CrudRepository<OrderDTO, Integer> {

}
