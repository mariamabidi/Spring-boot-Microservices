package com.microservices.demo.service;

import com.microservices.demo.client.ProductServiceClient;
import com.microservices.demo.client.UserServiceClient;
import com.microservices.demo.model.Order;
import com.microservices.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserServiceClient userServiceClient;
    private final ProductServiceClient productServiceClient;

    public Order placeOrder(Long userId, Long productId, int quantity) {
        if (!userServiceClient.validateUser(userId)) {
            throw new RuntimeException("Invalid user!");
        }

        if (!productServiceClient.checkStock(productId, quantity)) {
            throw new RuntimeException("Insufficient stock!");
        }

        double price = productServiceClient.getProductPrice(productId);
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(price * quantity);
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
