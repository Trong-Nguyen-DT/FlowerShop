package com.example.admin.Entity;


import com.example.admin.Domain.District;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @OneToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @OneToOne
    @JoinColumn(name = "district_id")
    private DistrictEntity districtEntity;

    @OneToOne
    @JoinColumn(name = "ward_id")
    private WardEntity wardEntity;

    private String street;

}
