package com.example.admin.Domain;

import com.example.admin.Entity.AddressEntity;
import com.example.admin.Entity.CustomerEntity;
import com.example.admin.Entity.UserEntity;
import com.example.admin.Entity.VoucherEntity;
import com.example.admin.enums.OrderStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class Order {
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    private double discount;

    private double amount;

    private Boolean confirmed;

    private Boolean status;

    private String note;

    private String informationRelated;

    private OrderStatus orderStatus;

    private boolean shipping;

    private double shipPrice;

    private boolean paymentOnline;

    private Address address;

    private Voucher voucher;

    private User user;

    private Customer customer;

    private List<OrderDetail> items;
}
