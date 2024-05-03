package com.zep.bankingkafka.repositories;

import com.zep.bankingkafka.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction ,String> {
}
