package com.example.admin.Service.Impl;

import com.example.admin.Converter.CustomerConverter;
import com.example.admin.Domain.Customer;
import com.example.admin.Repository.CustomerRepository;
import com.example.admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll().stream().map(CustomerConverter::toModel).toList();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(CustomerConverter.toEntity(customer));
    }

}
