package se.groceriesstore.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Cart;
import se.groceriesstore.demo.services.CartService;


@RestController
@RequestMapping("/addcart")

public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public void addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
    }

}
