package com.example.customer.service;

import com.example.customer.domain.Notification;
import com.example.customer.enums.TitleType;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotification(String name);

    Long addNotifyOrder(String name, Long id);

    void sendNotifyOrder(HttpHeaders headers, String name, Long notifyId, Long orderId);
}
