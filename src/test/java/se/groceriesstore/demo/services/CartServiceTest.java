package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.CartDAO;
import se.groceriesstore.demo.models.Cart;
import se.groceriesstore.demo.models.dto.CartDTO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    public static CartDAO cartDAO;
    public CartService cartService;

    @BeforeAll
    public static void initAll() {
        cartDAO = Mockito.mock(CartDAO.class);
    }

    @BeforeEach
    public void init () {
        cartService = new CartService(cartDAO);
    }

    @Test
    void addCart_ShouldAddNewCartAndSameProductName() {
        CartDTO cartDTOFromDatabase = new CartDTO(1, 99, "Mellanmjölk", 2, 3);
        CartDTO wrongCartDTOFromDatabase = new CartDTO(2, 92, "Lättmjölk", 1, 3);
        Cart newCart = new Cart(1, 99, "Mellanmjölk", 2, 3 );

        Mockito.when(cartDAO.addCart(ArgumentMatchers.any(CartDTO.class))).thenReturn(cartDTOFromDatabase);
        //Mockito.when(cartDAO.addCart(ArgumentMatchers.any(CartDTO.class))).thenReturn(wrongCartDTOFromDatabase);
        Cart createdCart = cartService.addCart(newCart);

        Assertions.assertThat(newCart.getProduct_name()).isEqualTo(createdCart.getProduct_name());
        //Assertions.assertThat(newCart.getProduct_name()).isNotEqualTo(createdCart.getProduct_name());
    }

    @Test
    void addCart_ShouldAddNewCartAndWrongProductName() {
        CartDTO wrongCartDTOFromDatabase = new CartDTO(2, 92, "Lättmjölk", 1, 3);
        Cart newCart = new Cart(1, 99, "Mellanmjölk", 2, 3 );

        Mockito.when(cartDAO.addCart(ArgumentMatchers.any(CartDTO.class))).thenReturn(wrongCartDTOFromDatabase);
        Cart createdCart = cartService.addCart(newCart);

        Assertions.assertThat(newCart.getProduct_name()).isNotEqualTo(createdCart.getProduct_name());
    }




}