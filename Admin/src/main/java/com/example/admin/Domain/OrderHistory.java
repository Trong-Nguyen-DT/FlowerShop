package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class OrderHistory {
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    private double discount;

    private double amount;

    private Long userId;

    private String fullNameStaff;

    private Long customerId;

    private String fullNameCustomer;

    private String phoneCustomer;

    private String emailCustomer;

    private List<OrderDetailHistory> orderDetailHistories;
}
