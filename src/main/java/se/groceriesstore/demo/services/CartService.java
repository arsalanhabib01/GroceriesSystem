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

    public Cart addCart(Cart cart) {
        CartDTO newCartDTO = cartDAO.addCart(mapFromCart(cart));
        return mapToCart(newCartDTO);
    }

    private Cart mapToCart(CartDTO newCartDTO) {
        return new Cart(newCartDTO.getId(), newCartDTO.getOrder_id(), newCartDTO.getProduct_name(), newCartDTO.getProduct_id(), newCartDTO.getAmount());
    }

    private CartDTO mapFromCart(Cart cart) {
        return new CartDTO(cart.getId(), cart.getOrder_id(), cart.getProduct_name(), cart.getProduct_id(), cart.getAmount());
    }


}

