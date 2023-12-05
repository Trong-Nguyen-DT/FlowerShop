package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class Order {
    private Long id;
    private double totalPrice;
    private double discount;
    private double amount;
    private String note;
    private double shipPrice;
    private boolean paymentOnline;
    private Long addressId;
    private Long voucherId;
    private List<Voucher> vouchers;
    private List<OrderDetail> items;
}
