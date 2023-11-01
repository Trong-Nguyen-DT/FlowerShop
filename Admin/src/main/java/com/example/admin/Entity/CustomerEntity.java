package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String avatar;

    private String phone;

    private String fullName;

    private String address;

    private String email;

    private boolean deleted;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntities;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities;
}
