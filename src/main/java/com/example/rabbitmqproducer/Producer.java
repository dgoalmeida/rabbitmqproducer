package com.example.rabbitmqproducer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Producer {

    private static final Logger LOG = LogManager.getLogger(Producer.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendMessage(String message) {

        LOG.info(message);
        rabbitTemplate.convertAndSend("default_exchange", "routing",
                message);
        return "Message(" + message + ")" + " has been produced.";

    }

}
