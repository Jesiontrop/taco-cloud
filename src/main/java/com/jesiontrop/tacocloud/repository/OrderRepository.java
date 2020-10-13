package com.jesiontrop.tacocloud.repository;

import com.jesiontrop.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
