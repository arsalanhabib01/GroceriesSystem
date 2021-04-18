package se.groceriesstore.demo.services;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.UserDAO;
import se.groceriesstore.demo.models.User;
import se.groceriesstore.demo.models.dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    public static UserDAO userDAO;
    public UserService userService;
    public List<UserDTO> allUsers;
    @BeforeAll
    public static void initAll(){
        userDAO = Mockito.mock(UserDAO.class);
    }
    @BeforeEach
    public void init(){
        Date date = new java.sql.Date(2000-01-01);
        userService = new UserService(userDAO);
        allUsers = new ArrayList<>();
        allUsers.add(new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1"));
        allUsers.add(new UserDTO("Maria","maria@gmail.com", date,"Kungsgatan, 2"));
        allUsers.add(new UserDTO("Mary","mary@gmail.com", date,"Kungsgatan, 3"));
    }
    @Test
    void getAllUser_ShouldReturnUsers() {
        Date date = new java.sql.Date(2000-01-01);
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User("joao","joao@gmail.com", date,"Kungsgatan, 1"));
        expectedUsers.add(new User("Maria","maria@gmail.com", date,"Kungsgatan, 2"));
        expectedUsers.add(new User("Mary","mary@gmail.com", date,"Kungsgatan, 3"));
        Mockito.when(userDAO.getAllUser()).thenReturn(allUsers);
        List<User> actualUsers = userService.getAllUsers();
        Assertions.assertThat(actualUsers.size()).isEqualTo(expectedUsers.size());
    }
    @Test
    void addUser_ShouldAddUserAndReturnCorrectEmail() {
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User newUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.addUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(userDTOFromBD);
        User createdUser = userService.addUser(newUser);
        Assertions.assertThat(newUser.getEmail()).isEqualTo(createdUser.getEmail());
    }
    @Test
    void addUser_ShouldAddUserAndReturnCorrectName() {
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User newUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.addUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(userDTOFromBD);
        User createdUser = userService.addUser(newUser);
        Assertions.assertThat(newUser.getName()).isEqualTo(createdUser.getName());
    }
    @Test
    void addUser_ShouldAddUserAndReturnCorrectBirthDay() {
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User newUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.addUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(userDTOFromBD);
        User createdUser = userService.addUser(newUser);
        Assertions.assertThat(newUser.getBirthday()).isEqualTo(createdUser.getBirthday());
    }
    @Test
    void addUser_ShouldAddUserAndReturnCorrectAddress() {
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User newUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.addUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(userDTOFromBD);
        User createdUser = userService.addUser(newUser);
        Assertions.assertThat(newUser.getAddress()).isEqualTo(createdUser.getAddress());
    }
    @Test
    void getUserById_ShouldFindUserByEmail() {
        String email = "joao@gmail.com";
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User expectedUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.getUserById(email)).thenReturn(Optional.of(userDTOFromBD));
        User actualUser = userService.getUserById(email);
        Assertions.assertThat(actualUser.getEmail()).isEqualTo(expectedUser.getEmail());
    }
    @Test
    void getUserById_ShouldFindUserByName() {
        String email = "joao@gmail.com";
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User expectedUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.getUserById(email)).thenReturn(Optional.of(userDTOFromBD));
        User actualUser = userService.getUserById(email);
        Assertions.assertThat(actualUser.getName()).isEqualTo(expectedUser.getName());
    }
    @Test
    void getUserById_ShouldFindUserByAdress() {
        String email = "joao@gmail.com";
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User expectedUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.getUserById(email)).thenReturn(Optional.of(userDTOFromBD));
        User actualUser = userService.getUserById(email);
        Assertions.assertThat(actualUser.getAddress()).isEqualTo(expectedUser.getAddress());
    }
    @Test
    void getUserById_ShouldFindUserByBirthDay() {
        String email = "joao@gmail.com";
        Date date = new java.sql.Date(2000-01-01);
        UserDTO userDTOFromBD = new UserDTO("joao","joao@gmail.com", date,"Kungsgatan, 1");
        User expectedUser = new User("joao","joao@gmail.com", date,"Kungsgatan, 1");
        Mockito.when(userDAO.getUserById(email)).thenReturn(Optional.of(userDTOFromBD));
        User actualUser = userService.getUserById(email);
        Assertions.assertThat(actualUser.getBirthday()).isEqualTo(expectedUser.getBirthday());
    }
    @Test
    void deleteUser_ShouldInvokeDeleteUser() {
        String email = "teste@delete.com";
        userService.deleteUser(email);
        Mockito.verify(userDAO,Mockito.times(1)).deleteUser(email);
    }
    @Test
    void deleteUser_Should_NotInvokeAddUser(){
        String email = "test@test.com";
        userService.deleteUser(email);
        Mockito.verify(userDAO, Mockito.times(0)).addUser((new UserDTO(null,null,null,null)));

    }
    @Test
    void updateUser_ShouldChangeUser() {
        Date date = new java.sql.Date(2000-01-01);
        Date dateToUpdate = new java.sql.Date(1970-02-03);
        String email = "joao@gmail.com";
        User newUser = new User("joao",email, date,"Kungsgatan, 1");
        UserDTO userDTOFromBDFirstIteration = new UserDTO("Mary",email, dateToUpdate,"Kungsgatan, 3");
        UserDTO userDTOFromBDSecondIteration = new UserDTO("joao",email, date,"Kungsgatan, 1");
        Mockito.when(userDAO.getUserById(email)).thenReturn(Optional.of(userDTOFromBDFirstIteration));
        Mockito.when(userDAO.addUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(userDTOFromBDSecondIteration);
        User actualUser = userService.updateUser(newUser,email);
        Assertions.assertThat(actualUser.getName()).isEqualTo(newUser.getName());
    }
}