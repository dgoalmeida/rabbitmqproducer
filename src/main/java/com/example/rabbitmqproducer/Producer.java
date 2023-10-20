package com.example.rabbitmqproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendMessage(String message) {
        rabbitTemplate.convertAndSend("default_exchange", "routing",
                message);
        return "Message(" + message + ")" + " has been produced.";

    }

}
