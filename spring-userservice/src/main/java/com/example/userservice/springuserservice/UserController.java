package com.example.userservice.springuserservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/userservice")
    public String userService() {

        InstanceInfo nextServerInfo = discoveryClient.getNextServerFromEureka("PAYMENT-SERVICE", false);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonServerInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(nextServerInfo);
            return "User Service | Using payment service: <BR/>" + jsonServerInfo.replace("\r\n", "<BR/>").replace(" ", "&nbsp&nbsp&nbsp&nbsp");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "User servicve error";
    }

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "srvA", commandKey = "srvA", threadPoolKey = "srvAThread")
    @GetMapping("/pay")
    public String pay() {
        String  url = "http://payment-service/paymentservice";
        return "User Service: Make payment: " +  restTemplate.getForObject(url, String.class) ;
    }

    public String fallback(Throwable hystrixCommand) {
        return "UserService: Payment Fall Back Message";
    }

}
