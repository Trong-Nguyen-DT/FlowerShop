package com.example.customer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "import_goods")
@Getter
@Setter
public class ImportGoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timeImport;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    private int quantity;

    private double totalPrice;
}
