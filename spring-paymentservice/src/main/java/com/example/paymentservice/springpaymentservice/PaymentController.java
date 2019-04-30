package com.example.paymentservice.springpaymentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/paymentservice")
    public String paymentService() {
        return "Payment Service";
    }
}
