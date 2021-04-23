package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.CartDTO;
import se.groceriesstore.demo.models.dto.OrderDTO;
import se.groceriesstore.demo.repository.OrderRepository;


@Repository
public class OrderDAO {

private final OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderDTO);
    }

}
