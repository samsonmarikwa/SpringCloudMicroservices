package com.samsonmarikwa.customer.service;

import com.samsonmarikwa.customer.dto.CustomerRegistrationRequest;
import com.samsonmarikwa.customer.dto.FraudCheckResponse;
import com.samsonmarikwa.customer.entity.Customer;
import com.samsonmarikwa.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
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
      
      // call fraud microservice
      String url = "http://localhost:8081/api/v1/fraud-check/{customerId}";
      FraudCheckResponse fraudCheck = restTemplate.getForObject(url, FraudCheckResponse.class, customer.getId());
      
      if (fraudCheck.isFraudster()) {
         throw new IllegalStateException("Fraudster detected");
      }
      
      // todo: send notification
      
   }
}
