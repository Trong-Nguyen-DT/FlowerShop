package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItem {

    private Long id;
    private Product product;
    private Long cart_Id;
    private int quantity;
}