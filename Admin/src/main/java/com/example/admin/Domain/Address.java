package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Address {
    private Long id;

    private City city;

    private District district;

    private Ward ward;

    private String street;
}
