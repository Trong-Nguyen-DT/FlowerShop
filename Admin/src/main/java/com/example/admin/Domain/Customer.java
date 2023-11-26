package com.example.admin.Domain;

import com.example.admin.Entity.AddressEntity;
import com.example.admin.Entity.CartEntity;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.ReviewEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    private List<OrderHistory> orders;

    private List<Review> reviews;
}
