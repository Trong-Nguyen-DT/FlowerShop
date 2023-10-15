package com.example.admin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_histories")
public class OrderHistoryEntity {
    @Id
    private Long id;
}
