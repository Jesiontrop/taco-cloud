package com.jesiontrop.tacocloud.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JmsOrderMessagingService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
