package com.spring.conf;

import com.spring.PrototypeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    PrototypeBean protoSix() {
        PrototypeBean bean =  new PrototypeBean();
        bean.x = 6;
        return bean;
    }
}
