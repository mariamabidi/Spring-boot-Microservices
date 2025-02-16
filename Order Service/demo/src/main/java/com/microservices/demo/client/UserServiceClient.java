package com.microservices.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8081/api/auth")
public interface UserServiceClient {
    @GetMapping("/validate")
    boolean validateUser(@RequestParam Long userId);
}
