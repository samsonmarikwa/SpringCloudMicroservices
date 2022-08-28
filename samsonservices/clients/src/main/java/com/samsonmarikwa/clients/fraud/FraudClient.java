package com.samsonmarikwa.clients.fraud;

import com.samsonmarikwa.clients.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("fraud") - required for eureka service discovery
// required for Kubernetes service discovery, the url is picked from the clients - <profile>.properties file
@FeignClient(name = "fraud", url = "${clients.fraud.url}")
public interface FraudClient {
   
   @GetMapping("api/v1/fraud-check/{customerId}")
   FraudCheckResponse isFraudster(@PathVariable Integer customerId);
   
}
