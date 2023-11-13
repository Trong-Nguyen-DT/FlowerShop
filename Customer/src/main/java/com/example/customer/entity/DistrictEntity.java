package com.example.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "district")
@Getter
@Setter
public class DistrictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @OneToOne(mappedBy = "districtEntity")
    private AddressEntity address;

    @OneToMany(mappedBy = "districtEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WardEntity> wardEntities;
}
