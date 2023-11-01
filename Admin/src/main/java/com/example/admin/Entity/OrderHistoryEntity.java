package com.example.admin.Entity;

import jakarta.persistence.*;
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
