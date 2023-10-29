package com.example.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Category {

    private Long id;

    private String name;

    private List<Product> products;

    private boolean deleted;
}

