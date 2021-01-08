package com.jesiontrop.tacocloud.messaging.jms;

import com.jesiontrop.tacocloud.model.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
