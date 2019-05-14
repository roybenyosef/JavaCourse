package com.example.reactiverest2.springreactiverest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringReactiverest2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(SpringReactiverest2Application.class, args);

		HobbitFlux h = context.getBean(HobbitFlux.class);
		h.getHobbitVod().subscribe(System.out::println);

		try { Thread.sleep(10000);} catch (Exception e) {}
		h.getHobbitLive().subscribe(System.out::println);
	}

}
