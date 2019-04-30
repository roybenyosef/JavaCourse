package com.example.rest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringRestApplication.class, args);

		RestTemplate client = new RestTemplate();
		int forObject = client.getForObject("http://localhost:8080/api/sum/5/6", Integer.class);
		System.out.println(forObject);
		Person person = Person.builder().name("aaa").age(42).build();

		Person result = client.postForObject("http://localhost:8080/api/persons", person, Person.class);
		System.out.println(result);
	}

}
