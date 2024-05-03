package com.zep.bankingkafka.services.impl;

import com.zep.bankingkafka.dtos.TransactionDto;
import com.zep.bankingkafka.models.Transaction;
import com.zep.bankingkafka.repositories.TransactionRepository;
import com.zep.bankingkafka.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public void saveTransaction(TransactionDto transactionDto) {
     Transaction transaction=Transaction.builder()
             .transactionType(transactionDto.getTransactionType())
             .accountNumber(transactionDto.getAccountNumber())
             .amount(transactionDto.getAmount())
             .status("SUCCESS")

             .build();
     transactionRepository.save(transaction);
     System.out.println("Saved transaction successfully");
    }
}
