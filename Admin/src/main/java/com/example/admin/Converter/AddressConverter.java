package com.example.admin.Converter;

import com.example.admin.Domain.Address;
import com.example.admin.Domain.Review;
import com.example.admin.Entity.AddressEntity;
import com.example.admin.Entity.ReviewEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {
    public static Address toModel(AddressEntity addressEntity) {
        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setCity(addressEntity.getNameCity());
        address.setDistrict(addressEntity.getNameDistrict());
        address.setWard(addressEntity.getNameWard());
        address.setStreet(addressEntity.getStreet());
        address.setNameCustomer(addressEntity.getNameCustomer());
        address.setPhoneNumber(addressEntity.getPhoneNumber());
//        address.setCustomer(CustomerConverter.toModel(addressEntity.getCustomerEntity()));
        return address;
    }
    public static AddressEntity toEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(address.getId());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setNameCustomer(address.getNameCustomer());
        addressEntity.setPhoneNumber(address.getPhoneNumber());
        addressEntity.setNameCity(address.getCity());
        addressEntity.setNameWard(address.getWard());
        addressEntity.setNameDistrict(address.getDistrict());

//        addressEntity.setCustomerEntity(CustomerConverter.toEntity(address.getCustomer()));

        return addressEntity;
    }
    public static List<AddressEntity> toEntityList(List<Address> addresses) {
        return addresses.stream()
                .map(AddressConverter::toEntity)
                .collect(Collectors.toList());
    }
}
