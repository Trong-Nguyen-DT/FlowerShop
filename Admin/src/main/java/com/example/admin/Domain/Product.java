package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;

    private String name;

    private String delivery;//Vận chuyển

    private String description;// Miêu tả

    private String details; // chi tiết

    private double discount;// giảm giá

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private double original_price;// giá gốc

    private int overall_rating;// trung bình sao

    private double price; // Giá

    private String sub_info; // Thông tin phụ

    private boolean deleted; // Đã xóa
}

