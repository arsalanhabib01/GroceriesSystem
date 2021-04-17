package se.groceriesstore.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.UserDAO;
import se.groceriesstore.demo.models.dto.UserDTO;
import se.groceriesstore.demo.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUser() {
        return userDAO;
    }



    public User addUser(User newUser) {
        UserDTO newUserDTO = userDAO.addUser(mapFromUser(newUser));

        return mapToUser(newUserDTO);
    }


    public User getUserById(String email) {
        Optional<UserDTO> maybeUserDTO = userDAO.getUserById(email);
        if (maybeUserDTO.isPresent()) {
            UserDTO userDTO = maybeUserDTO.get();
            return mapToUser(userDTO);
        }
        return null;
    }

    private User mapToUser(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail(), userDTO.getBirthday(), userDTO.getAddress());
    }

    public UserDTO mapFromUser(User newUser) {
        return new UserDTO(newUser.getName(), newUser.getEmail(), newUser.getBirthday(), newUser.getAddress());
    }
    //WORKING
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for(UserDTO userDTO: userDAO.getAllUser()){
            User user = mapToUser(userDTO);
            users.add(user);
        }
        return users;
    }

    public User updateUser(User newUser, String email) {

        User userToUpdate = getUserById(email);
        if(userToUpdate != null){
            userToUpdate.setName(newUser.getName());
            userToUpdate.setBirthday(newUser.getBirthday());
            userToUpdate.setAddress(newUser.getAddress());
        }else {
            userToUpdate.setEmail(email);
        }
        UserDTO updateUser = userDAO.addUser(mapFromUser(userToUpdate));
        return mapToUser(updateUser);
    }


    public void deleteUser(String email) {
        userDAO.deleteUser(email);
    }


    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for(UserDTO userDTO: userDAO.getAllUser()){
            User user = mapToUser(userDTO);
            users.add(user);
        }
        return users;
    }
}