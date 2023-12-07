package com.example.customer.service.Impl;

import com.example.customer.entity.CustomerEntity;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.requestBody.PnsRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;

import com.google.firebase.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FCMService{

    @Autowired
    private CustomerRepository customerRepository;

    public String pushNotification(String name, String content) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        Message message = Message.builder()
                .putData("content", content)
                .setToken(customerEntity.getToken())
                .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }


}

