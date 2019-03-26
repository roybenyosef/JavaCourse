package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimestampAspect {
    @Before("@target(TimestampAnnotation) || @annotation(TimestampAnnotation)")
    public void showTimestamp(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " was invoked on " + new Date());
    }
}
