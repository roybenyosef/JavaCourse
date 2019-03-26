package com.spring;

import com.aop.TimestampAnnotation;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
@Primary //this is the default
@TimestampAnnotation
public class PrototypeBean {
    public int x = (int)(Math.random()*100);

    @PostConstruct  //lifecycle events
    public void init() {
        System.out.println("Prototype - generated x: "  + x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
