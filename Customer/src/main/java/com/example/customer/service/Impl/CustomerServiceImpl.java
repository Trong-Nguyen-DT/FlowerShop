package com.example.customer.service.Impl;

import com.example.customer.converter.CustomerConverter;
import com.example.customer.domain.Customer;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Customer checkCustomer(String username, String password) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username).orElse(null);
        if (customerEntity != null && passwordEncoder.matches(password, customerEntity.getPassword())) {
            return CustomerConverter.toModel(customerEntity);
        }
        return null;
    }

    @Override
    public boolean checkUsername(String username) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username).orElse(null);
        return customerEntity == null;
    }

    @Override
    public void createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerRepository.save(customerEntity);
    }
}
