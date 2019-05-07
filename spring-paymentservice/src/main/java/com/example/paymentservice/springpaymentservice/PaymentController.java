package com.example.paymentservice.springpaymentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController
public class PaymentController {

    @Value("${eureka.instance.instanceId}")
    private String instanceId;


    @GetMapping("/paymentservice")
    public String paymentService() {
        return "Payment Service, instance: " + instanceId;
    }

    @GetMapping("/info")
    public String info() {
        return "info of " + instanceId;
    }
}
