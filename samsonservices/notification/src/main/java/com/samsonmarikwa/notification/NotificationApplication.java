package com.samsonmarikwa.notification;

import com.samsonmarikwa.amqp.RabbitMQMessageProducer;
import com.samsonmarikwa.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
      scanBasePackages = {"com.samsonmarikwa.notification", "com.samsonmarikwa.amqp"}
)
@EnableEurekaClient
@PropertySources({
      @PropertySource("classpath:clients-${spring.profiles.active}.yaml")
})
public class NotificationApplication {
   public static void main(String[] args) {
      SpringApplication.run(NotificationApplication.class, args);
   }
   
   /*
   // Code to test if the messaging is working
   @Bean
   CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
      return args -> {
         producer.publish(
               new Person("Samson", 20),
               notificationConfig.getInternalExchange(),
               notificationConfig.getInternalNotificationRoutingKey());
      
      };
   }
   */
   
   record Person(String name, int age) {}
   
}
