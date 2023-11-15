package com.example.admin.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ward")
@Getter
@Setter
public class WardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "wardEntity")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private DistrictEntity districtEntity;
}
