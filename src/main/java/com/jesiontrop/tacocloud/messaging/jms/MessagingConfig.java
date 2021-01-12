package com.jesiontrop.tacocloud.messaging.jms;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import javax.jms.Destination;

@Configuration
public class MessagingConfig {

    @Bean
    public Destination orderQueue() {
        return new ActiveMQQueue("taco.order.queue");
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter =
                                        new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");
        return messageConverter;
    }
}
