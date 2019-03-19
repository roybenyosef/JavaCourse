package com.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")

public class SingletonBean {
    public int x = (int)(Math.random()*100);

    @PostConstruct
    public void init() {
        System.out.println("Singleton - generated x: "  + x);
    }

    @PreDestroy
    public void exit() {
        System.out.println("Singleton is going down");
    }
}
