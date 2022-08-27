package com.samsonmarikwa.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// specify the base packages in order to inject the producer
@SpringBootApplication
      (scanBasePackages = {"com.samsonmarikwa.customer", "com.samsonmarikwa.amqp"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.samsonmarikwa.clients")
@PropertySources({
      @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
