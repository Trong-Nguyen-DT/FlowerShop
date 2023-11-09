package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
