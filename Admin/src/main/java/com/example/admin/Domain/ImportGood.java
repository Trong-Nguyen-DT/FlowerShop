package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ImportGood {
    private Long id;

    private LocalDateTime timeImport;

    private Item item;

    private int quantity;

    private double totalPrice;
}
