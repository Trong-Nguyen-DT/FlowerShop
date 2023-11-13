package com.example.admin.Service.Impl;

import com.example.admin.Entity.CustomerEntity;
import com.example.admin.Repository.CustomerRepository;
import com.example.admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> result = customerRepository.findAll();
        return result;
    }
}
