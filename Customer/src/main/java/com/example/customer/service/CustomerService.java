package com.example.customer.service;

import com.example.customer.domain.Customer;

public interface CustomerService {
    Customer checkCustomer(String username, String password);


    boolean checkUsername(String username);

    void createCustomer(Customer customer);

    void changePassword(Customer customer);

    Customer getCustomerByUsername(String name);
}
