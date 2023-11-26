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

//    @Override
//    public void addCustomer(Customer customer) {
//        customerRepository.save(CustomerConverter.toEntity(customer));
//    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return CustomerConverter.toModel(customerRepository.findById(customerId).orElseThrow());
    }

    @Override
    public void detailCustomer(Customer customer) {
//        CustomerEntity customerEntity = customerRepository.findById(customer.getId()).orElseThrow();
        customer.getFullName();
        customer.getEmail();
        customer.getAvatar();
        customer.getPassword();
        customer.getPhone();
        customer.getUsername();
    }

//    public void updateCustomer(Customer customer) {
//        CustomerEntity customerEntity = customerRepository.findById(customer.getId()).orElseThrow();
//        customerEntity.setFullName(customer.getFull_name());
//        customerEntity.setAddress(customer.getAddress());
//        customerEntity.setEmail(customer.getEmail());
//        customerEntity.setAvatar(customer.getAvatar());
//        customerEntity.setPassword(customer.getPassword());
//        customerEntity.setPhone(customer.getPhone());
//        customerEntity.setUsername(customer.getUsername());
//        customerRepository.save(customerEntity);
//    }

//    @Override
//    public void deleteCustomerById(Long customerId) {
//        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();
//        customerEntity.setDeleted(true);
//        customerRepository.save(customerEntity);
//    }

//    @Override
//    public void restoreCustomerById(Long customerId) {
//        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();
//        customerEntity.setDeleted(false);
//        customerRepository.save(customerEntity);
//    }

}
