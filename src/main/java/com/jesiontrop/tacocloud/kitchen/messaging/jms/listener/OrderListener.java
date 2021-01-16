package com.jesiontrop.tacocloud.kitchen.messaging.jms.listener;

import com.jesiontrop.tacocloud.kitchen.messaging.jms.KitchenUI;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class OrderListener {
    private KitchenUI kitchenUI;
    private Destination orderQueue;

}
