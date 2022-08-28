package com.samsonmarikwa.clients.notification;

import com.samsonmarikwa.clients.notification.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient("notification") - required for eureka service discovery
// required for Kubernetes service discovery, the url is picked from the clients - <profile>.properties file
@FeignClient(name = "notification", url = "${clients.notification.url}")
public interface NotificationClient {
   
   @PostMapping("api/v1/notification")
   void sendNotification(@RequestBody NotificationRequest notificationRequest);
   
}
