package com.example.admin.Converter;

import com.example.admin.Domain.Customer;
import com.example.admin.Entity.CustomerEntity;

public class CustomerConverter {
    public static Customer toModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setFullName(customerEntity.getFullName());
        customer.setEmail(customerEntity.getEmail());
        customer.setAvatar(customerEntity.getAvatar());
        customer.setPassword(customerEntity.getPassword());
        customer.setUsername(customerEntity.getUsername());
        customer.setPhone(customerEntity.getPhone());
        customer.setSex(customerEntity.isSex());

        customer.setOrders(customerEntity.getOrderEntities().stream().map(OrderConverter::OrderEntitytoOrderHistory).toList());
        customer.setReviews((customerEntity.getReviewEntities().stream().map(ReviewConverter::toModel).toList()));
        return customer;
    }
}
