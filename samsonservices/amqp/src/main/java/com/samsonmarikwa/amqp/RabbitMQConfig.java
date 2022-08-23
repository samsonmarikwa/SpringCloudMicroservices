package com.samsonmarikwa.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
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

   // Allows us to send messages to the queue
   @Bean
   public AmqpTemplate amqpTemplate() {
      // By default, we get the RabbitTemplate but because we need to customise it,
      // hence we have bring it into a configuration class to customise it.
      RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
      // This supports serializing java objects to json from the publisher and deserializing to java objects at the consumer
      rabbitTemplate.setMessageConverter(getJackson2JsonMessageConverter());
      return rabbitTemplate;
   }
   
   // Allows us to receive messages from the queue
   @Bean
   public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
      SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory);
      factory.setMessageConverter(getJackson2JsonMessageConverter());
      return factory;
   }
   
   private static MessageConverter getJackson2JsonMessageConverter() {
      return new Jackson2JsonMessageConverter();
   }
}
