package com.example.admin.Entity;


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

    private Long staff_id;

    private double totalPrice;
}
