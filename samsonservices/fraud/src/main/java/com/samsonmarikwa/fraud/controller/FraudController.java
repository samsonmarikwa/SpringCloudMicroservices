package com.samsonmarikwa.fraud.controller;

import com.samsonmarikwa.fraud.dto.FraudCheckResponse;
import com.samsonmarikwa.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
/*
public record FraudController(FraudCheckService fraudCheckService) {
Below we have used a class to replace the record as done in the other CustomerController. A record was
introduced in Java 17. The @AllArgsConstructor handles dependency injection through the constructor
*/
public class FraudController {
   
   private final FraudCheckService fraudCheckService;
   
   @GetMapping("/{customerId}")
   public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
      boolean isFraudlentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
      log.info("Fraud check request for customer {}", customerId);
      
      return new FraudCheckResponse(isFraudlentCustomer);
   }
}
