package com.example.customer.service.Impl;

import com.example.customer.converter.CustomerConverter;
import com.example.customer.domain.Customer;
import com.example.customer.domain.Otp;
import com.example.customer.entity.CartEntity;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.repository.CartRepository;
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

    @Autowired
    private CartRepository cartRepository;

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
        customerEntity = customerRepository.save(customerEntity);
        CartEntity cartEntity = new CartEntity();
        cartEntity.setCustomerEntity(customerEntity);
        cartRepository.save(cartEntity);
    }

    @Override
    public void changePassword(Customer customer) {
        CustomerEntity customerEntity = customerRepository.findByUsername(customer.getUsername()).orElse(null);
        if (customerEntity != null) {
            customerEntity.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(customerEntity);
        }
    }

    @Override
    public Customer getCustomerByUsername(String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElse(null);
        if (customerEntity != null) {
             return CustomerConverter.toModel(customerEntity);
        }
        return null;
    }

    @Override
    public Customer updateCustomer(String name, Customer newCustomer) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        customerEntity.setPhone(newCustomer.getPhone());
        customerEntity.setFullName(newCustomer.getFullName());
        customerEntity.setEmail(newCustomer.getEmail());
        customerEntity.setSex(newCustomer.isSex());
        customerEntity.setBirthday(newCustomer.getBirthday());
        return CustomerConverter.toModel(customerRepository.save(customerEntity));
    }
}
