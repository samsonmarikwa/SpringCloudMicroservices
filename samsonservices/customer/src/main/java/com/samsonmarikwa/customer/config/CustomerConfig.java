package com.samsonmarikwa.customer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class CustomerConfig {
   
//   @Bean
   // Annotation to mark a RestTemplate or WebClient bean to be configured to use a LoadBalancerClient.
   // Required when we have Eureka client enabled and RestTemplate calling an endpoint in another microservice
//   @LoadBalanced
   public RestTemplate restTemplate() {
      return new RestTemplate();
   }
}
