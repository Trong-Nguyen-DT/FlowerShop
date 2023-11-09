package com.example.admin.Domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetail {
    private Long id;

    private Long itemId;

    private Long productId;

    private int quantity;
}
