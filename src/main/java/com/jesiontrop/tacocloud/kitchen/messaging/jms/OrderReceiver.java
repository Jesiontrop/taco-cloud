package com.jesiontrop.tacocloud.kitchen.messaging.jms;

import com.jesiontrop.tacocloud.model.Order;

public interface OrderReceiver {
    public Order receiverOrder();
}
