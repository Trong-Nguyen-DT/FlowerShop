package com.example.admin.enums;
import com.fasterxml.jackson.annotation.JsonValue;
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
