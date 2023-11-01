package com.example.customer.converter;

import com.example.customer.domain.Customer;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.entity.OrderEntity;
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
        customer.setAddress(customerEntity.getAddress());
        customer.setEmail(customerEntity.getEmail());
        customer.setOrders(customerEntity.getOrderEntities().stream().map(OrderConverter::toModel).toList());
        customer.setReviews((customerEntity.getReviewEntities().stream().map(ReviewConverter::toModel).toList()));
        return customer;
    }
}
