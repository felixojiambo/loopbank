package com.zep.bankingkafka.dtos;

import com.zep.bankingkafka.models.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BankStatementResponse {
    private String message;
    private List<Transaction> transactions;
}
