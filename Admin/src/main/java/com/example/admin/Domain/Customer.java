package com.example.admin.Domain;

import com.example.admin.Entity.AddressEntity;
import com.example.admin.Entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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

    private List<Address> addresses;

    private String email;

    private boolean sex;

    private LocalDate birthday;

    private List<Order> orders;

    private List<Review> reviews;
}
