package com.example.admin.Converter;

import com.example.admin.Domain.Address;
import com.example.admin.Domain.City;
import com.example.admin.Domain.District;
import com.example.admin.Domain.Ward;
import com.example.admin.Entity.AddressEntity;
import com.example.admin.Entity.CityEntity;
import com.example.admin.Entity.DistrictEntity;
import com.example.admin.Entity.WardEntity;

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
