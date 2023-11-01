package com.example.admin.Service;

import com.example.admin.Domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    void addCustomer(Customer customer);
}
