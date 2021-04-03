package se.groceriesstore.demo.repository;

import org.springframework.data.repository.CrudRepository;
import se.groceriesstore.demo.models.dto.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {
}
