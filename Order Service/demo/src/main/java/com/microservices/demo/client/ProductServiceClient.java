package com.microservices.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "http://localhost:8082/api/products")
public interface ProductServiceClient {
    @GetMapping("/check-stock")
    boolean checkStock(@RequestParam Long productId, @RequestParam int quantity);

    @GetMapping("/price")
    double getProductPrice(@RequestParam Long productId);
}
