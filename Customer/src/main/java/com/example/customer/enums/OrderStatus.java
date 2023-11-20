package com.example.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    WAITTING,
    CONFIRMED,
    SENT,
    RECEIVED,
    CANCELLED,
    REJECT;
}
