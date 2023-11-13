package com.example.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "cityEntity")
    private AddressEntity address;

    @OneToMany(mappedBy = "cityEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DistrictEntity> districtEntities;
}
