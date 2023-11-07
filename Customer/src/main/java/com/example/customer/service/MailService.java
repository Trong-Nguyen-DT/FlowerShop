package com.example.customer.service;

import com.example.customer.requestBody.EmailRequest;

public interface MailService {
    String sendEmail(String to);
}
