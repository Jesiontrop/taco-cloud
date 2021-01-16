package com.jesiontrop.tacocloud.kitchen.messaging.jms.listener;

import com.jesiontrop.tacocloud.kitchen.messaging.jms.KitchenUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class OrderListener {
    private KitchenUI kitchenUI;
    private Destination orderQueue;

    @Autowired
    public OrderListener(KitchenUI kitchenUI, Destination orderQueue) {
        this.kitchenUI = kitchenUI;
        this.orderQueue = orderQueue;
    }
}
