package se.groceriesstore.demo.services;


import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.CartDAO;
import se.groceriesstore.demo.models.Cart;
import se.groceriesstore.demo.models.dto.CartDTO;

@Service
public class CartService {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void addCart(Cart cart) {
        cartDAO.addCart(mapFromCart(cart));
    }

    private CartDTO mapFromCart(Cart cart) {
        return new CartDTO(cart.getId(), cart.getOrder_id(), cart.getProduct_name(), cart.getProduct_id(), cart.getAmount());
    }


}

