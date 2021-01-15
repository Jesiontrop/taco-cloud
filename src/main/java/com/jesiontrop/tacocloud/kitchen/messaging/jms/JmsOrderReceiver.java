package com.jesiontrop.tacocloud.kitchen.messaging.jms;

import com.jesiontrop.tacocloud.kitchen.OrderReceiver;
import com.jesiontrop.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jmsTemplate;
    private MessageConverter messageConverter;
    private Destination orderQueue;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter, Destination orderQueue) {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = messageConverter;
        this.orderQueue = orderQueue;
    }

    @Override
    public Order receiverOrder() {
        return (Order) jmsTemplate.receiveAndConvert(orderQueue);
    }

}
