package com.example.customer.service;

import com.example.customer.domain.Customer;

public interface CustomerService {
    Customer checkCustomer(String username, String password);
}
