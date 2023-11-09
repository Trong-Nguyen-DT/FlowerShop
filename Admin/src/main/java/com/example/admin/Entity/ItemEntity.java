package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private boolean deleted;

    // Nhiều ProductDetailEntity cho mỗi ItemEntity
//    @ManyToOne
//    @JoinColumn(name = "product_detail_id")
//    private ProductDetailEntity productDetail
}
