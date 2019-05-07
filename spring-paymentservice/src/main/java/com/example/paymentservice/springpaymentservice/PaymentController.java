package com.example.paymentservice.springpaymentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController
public class PaymentController {

    @GetMapping("/paymentservice")
    public String paymentService() {
        return "Payment Service";
    }

    @GetMapping("/info")
    public String info() {
        return "info of " + ManagementFactory.getRuntimeMXBean().getName();
    }
}
