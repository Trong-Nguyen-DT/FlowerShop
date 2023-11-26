package com.example.customer.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private String name;
    private long price;
    private int quantity;
}
