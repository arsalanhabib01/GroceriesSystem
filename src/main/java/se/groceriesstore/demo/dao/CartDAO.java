package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.CartDTO;
import se.groceriesstore.demo.repository.CartRepository;


@Repository
public class CartDAO {

private final CartRepository cartRepository;

    public CartDAO(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDTO addCart(CartDTO cartDTO) {
        return cartRepository.save(cartDTO);
    }

}
