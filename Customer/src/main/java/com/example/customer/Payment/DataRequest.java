package com.example.customer.Payment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataRequest {
    private String name;
    private long price;
    private int quantity;
}
