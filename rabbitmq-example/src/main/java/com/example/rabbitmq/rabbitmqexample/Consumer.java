package com.example.rabbitmq.rabbitmqexample;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "QueueA")
    public void receiveMessage1(String msg) {
        System.out.println("Received message queue a: " + msg);
    }

    @RabbitListener(queues = "QueueB")
    public void receiveMessage2(String msg) {
        System.out.println("Received message queue b: " + msg);
    }

}
