package com.example.userservice.springuserservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/userservice")
    public String userService() {
        return "User Service";
    }
}
