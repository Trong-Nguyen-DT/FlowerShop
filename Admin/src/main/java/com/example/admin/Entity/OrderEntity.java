package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    private double discount;

    private double amount;

    private Boolean confirmed;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails;
}
