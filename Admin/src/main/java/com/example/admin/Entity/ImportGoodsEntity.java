package com.example.admin.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "import_goods")
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
