package com.samsonmarikwa.notification.rabbitmq;

import com.samsonmarikwa.clients.notification.dto.NotificationRequest;
import com.samsonmarikwa.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
   
   private final NotificationService notificationService;
   
   @RabbitListener(queues = "${rabbitmq.queue.notification}")
   public void consumer(NotificationRequest notificationRequest) {
      
      log.info("Consumed {} from queue", notificationRequest);
      notificationService.sendNotification(notificationRequest);
   
   }
}
