package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.repository.UserRepository;
import se.groceriesstore.demo.models.dto.UserDTO;


@Repository
public class UserDAO {
    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(UserDTO userDTO){
        userRepository.save(userDTO);
    }
    public void findUserById(Integer id){ userRepository.findById(id); }
}
