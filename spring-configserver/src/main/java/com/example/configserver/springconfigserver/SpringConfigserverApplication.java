package com.example.configserver.springconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigserverApplication {
	public static void main(String[] args) {
		//Test by going to http://localhost:9999/user-service/master
		SpringApplication.run(SpringConfigserverApplication.class, args);
	}

}
