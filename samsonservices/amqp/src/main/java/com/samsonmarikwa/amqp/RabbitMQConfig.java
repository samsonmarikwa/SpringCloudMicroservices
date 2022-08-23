package com.samsonmarikwa.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {
   
   private final ConnectionFactory connectionFactory;

   @Bean
   public AmqpTemplate amqpTemplate() {
      // By default, we get the RabbitTemplate but because we need to customise it,
      // hence we have bring it into a configuration class to customise it.
      RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
      // This supports serializing java objects to json from the publisher and deserializing to java objects at the consumer
      rabbitTemplate.setMessageConverter(getJackson2JsonMessageConverter());
      return rabbitTemplate;
   }
   
   @Bean
   public MessageConverter getJackson2JsonMessageConverter() {
      return new Jackson2JsonMessageConverter();
   }
}
