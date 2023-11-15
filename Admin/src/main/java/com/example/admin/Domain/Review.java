package com.example.admin.Domain;


import com.example.admin.Entity.CustomerEntity;
import com.example.admin.Entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Review {
    private Long id;

    private Product product;

    private double rate;

    private String content;

    private String name;

    private LocalDate date;

    private Customer customer;
}
