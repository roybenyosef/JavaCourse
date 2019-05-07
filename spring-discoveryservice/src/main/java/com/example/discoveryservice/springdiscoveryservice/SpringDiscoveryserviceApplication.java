package com.example.discoveryservice.springdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringDiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryserviceApplication.class, args);
	}

}
