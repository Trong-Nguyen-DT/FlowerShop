package com.example.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private Long orderCode;
    private Long amount;
    private String description;
    private Long customer_id;
    private String buyerName;
    private String buyerPhone;
    private String returnUrl;
    private String cancelUrl;
    private String signature;
    private long expiredAt;
    private List<OrderDetail> items;

}
