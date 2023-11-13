package com.example.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderHistory {
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

    private List<OrderDetailHistory> orderDetailHistories;
}
