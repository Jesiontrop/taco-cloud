package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Order;
import com.jesiontrop.tacocloud.repository.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId,
                            @RequestBody Order patch) {

        Order order = orderRepository.findById(orderId).get();

        if (patch.getDeliveryName() != null)
            order.setDeliveryName(patch.getDeliveryName());

        if (patch.getDeliveryStreet() != null)
            order.setDeliveryStreet(patch.getDeliveryStreet());

        if (patch.getDeliveryCity() != null)
            order.setDeliveryCity(patch.getDeliveryCity());

        if (patch.getDeliveryState() != null)
            order.setDeliveryState(patch.getDeliveryState());

        if (patch.getDeliveryZip() != null)
            order.setDeliveryZip(patch.getDeliveryZip());

        if (patch.getCcNumber() != null)
            order.setCcNumber(patch.getCcNumber());

        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }

        return orderRepository.save(order);
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }
}
