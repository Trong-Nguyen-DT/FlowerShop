package com.example.admin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail_histories")
public class OrderDetailHistoryEntity {
    @Id
    private Long id;
}
