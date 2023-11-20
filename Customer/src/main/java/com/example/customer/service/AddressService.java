package com.example.customer.service;

import com.example.customer.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddressByCustomer(String name);
    void addAddress(String name, Address address);
}
