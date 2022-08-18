package com.samsonmarikwa.customer.service;

import com.samsonmarikwa.clients.fraud.FraudClient;
import com.samsonmarikwa.clients.fraud.dto.FraudCheckResponse;
import com.samsonmarikwa.customer.dto.CustomerRegistrationRequest;
import com.samsonmarikwa.customer.entity.Customer;
import com.samsonmarikwa.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
   public void registerCustomer(CustomerRegistrationRequest request) {
      Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
      
      // todo: check if email is valid
      // todo: check if email not taken
      
      // save customer record
      customerRepository.save(customer);
      
      // call fraud microservice - FRAUD is the spring.application.name given to the fraud microservice.
      /*
         String url = "http://FRAUD/api/v1/fraud-check/{customerId}";
         FraudCheckResponse fraudCheck = restTemplate.getForObject(url, FraudCheckResponse.class, customer.getId());
         
         Instead of restTemplate, we now use the Feign Client that has been defined in it's own module to allow code
         reuse.
      */
      FraudCheckResponse fraudCheck = fraudClient.isFraudster(customer.getId());
      if (fraudCheck.isFraudster()) {
         throw new IllegalStateException("Fraudster detected");
      }
      
      // todo: send notification
      
   }
}
