package com.jesiontrop.tacocloud.kitchen.messaging.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiver {
    private JmsTemplate jmsTemplate;
}
