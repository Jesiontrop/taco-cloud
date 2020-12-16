package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Order;
import com.jesiontrop.tacocloud.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderApiController {
    private OrderRepository orderRepository;

    public OrderApiController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public Iterable<Order> allOrders() {
        return orderRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public Order putOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

}
