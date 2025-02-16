package com.microservices.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // User placing the order
    private Long productId; // Product being ordered
    private int quantity;
    private double totalPrice;
    private LocalDateTime orderDate;
}
