package com.example.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private double percentage;
    private int usageLimit;
    private LocalDate startDate;
    private LocalDate endDate;
    private double conditionPrice;
    private boolean expired;
}
