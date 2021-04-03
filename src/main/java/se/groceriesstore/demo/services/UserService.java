package se.groceriesstore.demo.services;


import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.UserDAO;

@Service
public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUser(){
        return userDAO;
    }
}
