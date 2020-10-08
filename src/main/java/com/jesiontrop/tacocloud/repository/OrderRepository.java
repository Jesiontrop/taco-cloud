package com.jesiontrop.tacocloud.repository;

import com.jesiontrop.tacocloud.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
