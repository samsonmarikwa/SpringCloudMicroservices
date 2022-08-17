package com.samsonmarikwa.fraud.service;

import com.samsonmarikwa.fraud.entity.FraudCheckHistory;
import com.samsonmarikwa.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
   
   public boolean isFraudlentCustomer(Integer customerId) {
      fraudCheckHistoryRepository.save(
            FraudCheckHistory.builder()
                  .customerId(customerId)
                  .isFraudster(false)
                  .createdAt(LocalDateTime.now())
                  .build()
      );
      return false;
      
   }
}
