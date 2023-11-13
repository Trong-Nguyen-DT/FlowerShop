package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.domain.Otp;

public interface CustomerService {
    Customer checkCustomer(String username, String password);

    boolean checkUsername(String username);

    void createCustomer(Customer customer);

    void changePassword(Customer customer);

    Customer getCustomerByUsername(String name);

    Customer updateCustomer(String name, Customer newCustomer);
}
