package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
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

    private double overall_rating;

    private double discount;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private boolean deleted;

//    @Transient
    private double finalPrice;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities;

    @ManyToMany(mappedBy = "productEntities", fetch = FetchType.EAGER)
    private List<CategoryEntity> categoryEntities;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetailEntities;

//    // Nhiều ProductDetailEntity cho mỗi ProductEntity
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<ProductDetailEntity> productDetails;

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
        updateFinalPrice();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        updateFinalPrice();
    }

    @PreUpdate
    public void updateFinalPrice() {
        this.finalPrice = calculateFinalPrice();
        this.price = finalPrice; // Cập nhật trường price khi finalPrice thay đổi
    }

    private double calculateFinalPrice() {
        return original_price - ((original_price * discount) / 100);
    }

}
