package com.example.admin.Domain;

import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetail {
    private Long id;

//    private OrderEntity orderEntity;
    private Long orderId;

//    private ProductEntity productEntity;
    private Long productId;


    private int quantity;
}
