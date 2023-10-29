package com.example.customer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "bonus")
@Getter
@Setter
public class BonusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @DateTimeFormat(pattern = "MM/yyyy")
    private LocalDate monthBonus;

    private double bonusMoney;
}
