package com.example.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_histories")
@Getter
@Setter
public class OrderHistoryEntity {
    @Id
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    private double discount;

    private double amount;

    private Long userId;

    private String fullNameStaff;

    private String role;

    private Long customerId;

    private String fullNameCustomer;

    private String phoneCustomer;

    private String emailCustomer;

    @OneToMany(mappedBy = "orderHistoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailHistoryEntity> orderDetailHistoryEntities;
}
