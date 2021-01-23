package com.jesiontrop.tacocloud.messaging.rabbitmq;

import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService{
    @Override
    public void sendOrder(Order order) {

    }
}
