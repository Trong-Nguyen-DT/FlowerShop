package com.example.customer.converter;

import com.example.customer.domain.Address;
import com.example.customer.domain.City;
import com.example.customer.domain.District;
import com.example.customer.domain.Ward;
import com.example.customer.entity.AddressEntity;
import com.example.customer.entity.CityEntity;
import com.example.customer.entity.DistrictEntity;
import com.example.customer.entity.WardEntity;

public class AddressConverter {

    public static Address toModel(AddressEntity addressEntity) {
        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setCity(toModelCity(addressEntity.getCityEntity()));
        address.setDistrict(toModelDistrict(addressEntity.getDistrictEntity()));
        address.setWard(toModelWard(addressEntity.getWardEntity()));
        address.setStreet(addressEntity.getStreet());
        return address;
    }

    public static City toModelCity(CityEntity cityEntity) {
        City city = new City();
        city.setId(cityEntity.getId());
        city.setName(cityEntity.getName());
        return city;
    }

    public static District toModelDistrict(DistrictEntity districtEntity) {
        District district = new District();
        district.setId(districtEntity.getId());
        district.setName(districtEntity.getName());
        return district;
    }

    public static Ward toModelWard(WardEntity wardEntity) {
        Ward ward = new Ward();
        ward.setId(wardEntity.getId());
        ward.setName(wardEntity.getName());
        return ward;
    }
}
