package com.example.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Voucher {
    private Long id;
    private String title;
    private String code;
    private double percentage;
    private int usageLimit;
    private LocalDate startDate;
    private LocalDate endDate;
    private double conditionPrice;
    private boolean expired;
}
