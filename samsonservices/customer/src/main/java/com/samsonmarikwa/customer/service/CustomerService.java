package com.samsonmarikwa.customer.service;

import com.samsonmarikwa.customer.dto.CustomerRegistrationRequest;
import com.samsonmarikwa.customer.entity.Customer;
import com.samsonmarikwa.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
   public void registerCustomer(CustomerRegistrationRequest request) {
      Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
      
      // todo: check if email is valid
      // todo: check if email not taken
      // todo: check if fraudster
      
      // save customer record
      customerRepository.save(customer);
      // todo: send notification
      
   }
}
