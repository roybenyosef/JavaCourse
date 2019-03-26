package com.example.jpa.springjpa.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Value("${myProp}")
    private int x;

    public int getX() {
        return x;
    }
}
