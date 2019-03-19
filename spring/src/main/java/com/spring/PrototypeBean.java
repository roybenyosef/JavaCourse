package com.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class PrototypeBean {
    public int x = (int)(Math.random()*100);

    @PostConstruct
    public void init() {
        System.out.println("Prototype - generated x: "  + x);
    }
}
