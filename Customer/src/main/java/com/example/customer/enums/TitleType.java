package com.example.customer.enums;

import lombok.Getter;

@Getter
public enum TitleType {
    SALE,
    WAITING,
    CONFIRMED,
    SENT,
    RECEIVED,
    CANCELLED,
    REJECT;
}
