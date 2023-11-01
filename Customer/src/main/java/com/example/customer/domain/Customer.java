package com.example.customer.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {

    private Long id;

    private String username;

    private String password;

    private String avatar;

    private String phone;

    private String fullName;

    private String address;

    private String email;


    private List<Order> orders;

    private List<Review> reviews;
}
