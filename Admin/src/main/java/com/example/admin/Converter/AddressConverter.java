package com.example.admin.Converter;

import com.example.admin.Domain.Address;
import com.example.admin.Entity.AddressEntity;
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
        return address;
    }
}
