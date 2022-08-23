package com.samsonmarikwa.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// specify the base packages in order to inject the producer
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.samsonmarikwa.clients")
public class CustomerApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
