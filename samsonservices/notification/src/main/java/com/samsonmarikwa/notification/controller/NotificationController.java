package com.samsonmarikwa.notification.controller;

import com.samsonmarikwa.clients.notification.dto.NotificationRequest;
import com.samsonmarikwa.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
   
   private final NotificationService notificationService;
   
   @PostMapping
   public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
      log.info("Send notification request: {}", notificationRequest);
      notificationService.sendNotification(notificationRequest);
   }
}
