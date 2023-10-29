package com.example.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_histories")
@Getter
@Setter
public class OrderHistoryEntity {
    @Id
    private Long id;
}
