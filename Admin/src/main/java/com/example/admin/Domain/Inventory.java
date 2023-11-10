package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Inventory {

    private Long id;

    private Item itemId;

    private int quantity;
}
