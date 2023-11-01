package com.example.admin.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_detail_histories")
@Getter
@Setter
public class OrderDetailHistoryEntity {
    @Id
    private Long id;
}
