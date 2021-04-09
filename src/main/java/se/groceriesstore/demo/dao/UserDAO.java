package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.repository.UserRepository;
import se.groceriesstore.demo.models.dto.UserDTO;

import java.util.Optional;


@Repository
public class UserDAO {
    private  final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO addUser(UserDTO userDTO){
        userRepository.save(userDTO);
        return userDTO;
    }
    public void findUserById(String email){ userRepository.findById(email); }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    public Iterable<UserDTO> getAllUser() {
        return userRepository.findAll();
    }

}
