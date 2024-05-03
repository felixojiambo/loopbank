package com.zep.bankingkafka.services;

import com.zep.bankingkafka.dtos.TransactionDto;
import com.zep.bankingkafka.models.Transaction;

public interface TransactionService {
void saveTransaction(TransactionDto transactionDto);
}
