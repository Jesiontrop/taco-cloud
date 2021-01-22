package com.jesiontrop.tacocloud.messaging.rabbitmq;

import com.jesiontrop.tacocloud.model.Order;

public interface OrderMessagingService {

    public void sendOrder(Order order);
}
