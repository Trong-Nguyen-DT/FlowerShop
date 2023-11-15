package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailHistory {
    private Long id;

    private Long orderHistory_id;

    private Long productId;

    private String nameProduct;

    private double priceProduct;

    private int quantity;
}
