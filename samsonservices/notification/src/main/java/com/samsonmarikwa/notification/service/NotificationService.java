package com.samsonmarikwa.notification.service;

import com.samsonmarikwa.clients.notification.dto.NotificationRequest;
import com.samsonmarikwa.notification.entity.Notification;
import com.samsonmarikwa.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
   
   private final NotificationRepository notificationRepository;
   
   public void sendNotification(NotificationRequest notificationRequest) {
      Notification notification = Notification.builder()
            .toCustomerId(notificationRequest.toCustomerId())
            .toCustomerEmail(notificationRequest.toCustomerEmail())
            .sender("SamsonServices")
            .message(notificationRequest.message())
            .sentAt(LocalDateTime.now())
            .build();
      
      notificationRepository.save(notification);
      
   }
}
