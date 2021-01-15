package com.jesiontrop.tacocloud.kitchen.messaging.jms;

import com.jesiontrop.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(Order order) {
        log.info("RECEIVED ORDER: " + order);
    }
}
