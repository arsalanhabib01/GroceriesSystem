package se.groceriesstore.demo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.CartDAO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    public static CartDAO cartDAO;
    public CartService cartService;

    @BeforeEach
    public void init () {
        cartService = new CartService(cartDAO);
    }

    @Test
    void addCart() {
    }

}