package com.example.admin.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double original_price;

    private double price;

    private String description;

    private String details;

    private String delivery;

    private String sub_info;

    private int overall_rating;

    private Long discount;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private boolean deleted;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities;

    @ManyToMany(mappedBy = "productEntities", fetch = FetchType.EAGER)
    private List<CategoryEntity> categoryEntities;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetailEntities;

}
