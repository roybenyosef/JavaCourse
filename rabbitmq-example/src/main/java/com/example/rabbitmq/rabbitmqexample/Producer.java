package com.example.rabbitmq.rabbitmqexample;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message, String routingKey) {
        System.out.println("Sender - sending message: " + message);
        rabbitTemplate.convertAndSend("topicEx", routingKey, message);
    }
}
