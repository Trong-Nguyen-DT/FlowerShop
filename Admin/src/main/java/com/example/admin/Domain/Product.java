package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Product {

    private Long id;

    private String name;

    private Long originalPrice;

    private Long price;

    private String description;

    private String details;

    private String delivery;

    private String sub_info;

    private double overall_rating;

    private Long discount;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private FlashSale flashSale;

    private boolean deleted;

    private List<Review> reviews;

    private List<Category> categories;
}
