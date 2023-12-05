package com.example.admin.Domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetail {
    private Long id;

    private Item item;

    private Product product;

    private int quantity;
}
