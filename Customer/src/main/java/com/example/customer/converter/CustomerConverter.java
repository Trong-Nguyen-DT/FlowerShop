package com.example.customer.converter;

import com.example.customer.domain.Customer;
import com.example.customer.domain.OrderHistory;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.entity.OrderEntity;
import com.example.customer.entity.OrderHistoryEntity;
import com.example.customer.entity.ReviewEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class CustomerConverter {
    public static Customer toModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setUsername(customerEntity.getUsername());
        customer.setAvatar(customerEntity.getAvatar());
        customer.setPhone(customerEntity.getPhone());
        customer.setFullName(customerEntity.getFullName());
        customer.setEmail(customerEntity.getEmail());
        customer.setSex(customerEntity.isSex());
        customer.setBirthday(customerEntity.getBirthday());
        customer.setAddresses(customerEntity.getAddressEntities().stream().map(AddressConverter::toModel).toList());
        customer.setReviews((customerEntity.getReviewEntities().stream().map(ReviewConverter::toModel).toList()));
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getId());
        entity.setPhone(customer.getPhone());
        entity.setFullName(customer.getFullName());
        entity.setEmail(customer.getEmail());
        return entity;
    }
}
