package se.groceriesstore.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.groceriesstore.demo.models.Cart;
import se.groceriesstore.demo.models.Order;
import se.groceriesstore.demo.services.CartService;
import se.groceriesstore.demo.services.OrderService;


@RestController
@RequestMapping("/addorder")

public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public void addCart(@RequestBody Order order) {
        orderService.addOrder(order);
    }

}
