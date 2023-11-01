package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {
    private Long id;

    private String full_name;

    private String address;

    private String email;

    private String phone;

    private String avatar;

    private String username;

    private String password;

    private boolean deleted; // Đã xóa
}
