package com.example.admin.Converter;

import com.example.admin.Domain.Customer;
import com.example.admin.Entity.CustomerEntity;

public class CustomerConverter {
    public static Customer toModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setFull_name(customerEntity.getFullName());
        customer.setAddress(customerEntity.getAddress());
        customer.setEmail(customerEntity.getEmail());
        customer.setAvatar(customerEntity.getAvatar());
        customer.setPassword(customerEntity.getPassword());
        customer.setUsername(customerEntity.getUsername());
        customer.setPhone(customerEntity.getPhone());
        customer.setDeleted(customerEntity.isDeleted());
        //customer.setCustomers(customerEntity.getCustomerEntities().stream().map(CustomerConverter::toModel).toList());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFullName(customer.getFull_name());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setAvatar(customer.getAvatar());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setDeleted(false);
        //categoryEntity.setDeleted(false);
        return customerEntity;
    }
}
