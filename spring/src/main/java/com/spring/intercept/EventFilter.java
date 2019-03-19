 package com.spring.intercept;

import com.spring.PrototypeBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

 @Component
public class EventFilter implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PrototypeBean && !beanName.equals("protosix")) {
            PrototypeBean ins = (PrototypeBean)bean;
            if (ins.x % 2 != 0) {
                System.out.println("Updating x value (" + ins.x  + ") to be even");
                ins.x++;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PrototypeBean && !beanName.equals("protosix")) {
            System.out.println("prototype bean X: " +  ((PrototypeBean)bean).x);
        }
        return bean;
    }
}
