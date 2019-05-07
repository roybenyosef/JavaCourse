package com.example.userservice.springuserservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private EurekaClient discoveryClient;


    @GetMapping("/userservice")
    public String userService() {

        InstanceInfo nextServerInfo = discoveryClient.getNextServerFromEureka("PAYMENT-SERVICE", false);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonServerInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(nextServerInfo);
            return "User Service | Using payment service: " + jsonServerInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "User servicve error";
    }
}
