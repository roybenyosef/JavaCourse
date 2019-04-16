package com.example.rabbitmq.rabbitmqexample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {


    @Bean
    public Queue queueA() {
        return new Queue("QueueA", false);
    }

    @Bean
    public Queue queueB() {
        return new Queue("QueueB", false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicEx");
    }

    @Bean
    public Binding bindingA(TopicExchange ex) {
        return BindingBuilder.bind(queueA()).to(ex).with("mq.A");
    }

    @Bean
    public Binding bindingB(TopicExchange ex) {
        return BindingBuilder.bind(queueB()).to(ex).with("mq.B");
    }

}
