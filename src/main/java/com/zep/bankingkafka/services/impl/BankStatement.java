package com.zep.bankingkafka.services.impl;
import com.zep.bankingkafka.models.Transaction;
import com.zep.bankingkafka.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class BankStatement {
    private TransactionRepository transactionRepository;
    /*retrieve list of transactions within a date range given an account number
    *generate pdf file of transaction
    * send the file via email
     */

    public List<Transaction>generateStatement(String accountNumber,String startDate, String endDate){
        LocalDate start=LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end=LocalDate.parse(endDate,DateTimeFormatter.ISO_DATE);
        List<Transaction>transactionList;
        transactionList = transactionRepository.findAll().stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> transaction.getCreatedAt().isEqual(start.atStartOfDay())).filter(transaction -> transaction.getCreatedAt().isEqual(end.atStartOfDay())).toList();
        return  transactionList;
    }
}
