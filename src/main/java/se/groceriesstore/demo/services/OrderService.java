package se.groceriesstore.demo.services;


import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.OrderDAO;
import se.groceriesstore.demo.models.Order;
import se.groceriesstore.demo.models.dto.OrderDTO;

@Service
public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order addOrder(Order order) {
        OrderDTO newOrderDTO = orderDAO.addOrder(mapFromOrder(order));
        return mapToOrder(newOrderDTO);
    }

    private Order mapToOrder(OrderDTO newOrderDTO) {
        return new Order(newOrderDTO.getId(), newOrderDTO.getCustomer_id(), newOrderDTO.getTime(), newOrderDTO.getDate(), newOrderDTO.getStatus());
    }

    private OrderDTO mapFromOrder(Order order) {
        return new OrderDTO(order.getId(), order.getCustomer_id(), order.getTime(), order.getDate(), order.getStatus());
    }


}

