package com.jesiontrop.tacocloud.repository;

import com.jesiontrop.tacocloud.model.Order;
import com.jesiontrop.tacocloud.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user);
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
