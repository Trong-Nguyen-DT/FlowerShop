package com.example.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    private double discount;

    private double amount;

    private double subPrice;

    private double shipPrice;

    private String note;

    private Address address;

    List<OrderDetail> orderDetails;

    private Voucher voucher;

    private boolean shipping;

    private boolean paymentOnline;


}
