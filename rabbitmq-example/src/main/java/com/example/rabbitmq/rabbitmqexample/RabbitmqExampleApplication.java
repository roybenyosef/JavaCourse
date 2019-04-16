package com.example.rabbitmq.rabbitmqexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqExampleApplication implements CommandLineRunner {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send("msg1", "mq.A");
		producer.send("msg2", "mq.B");
		producer.send("msg3", "mq.A");
		producer.send("msg4", "mq.B");
	}
}
