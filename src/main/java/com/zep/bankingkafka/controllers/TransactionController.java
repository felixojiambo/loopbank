package com.zep.bankingkafka.controllers;

import com.itextpdf.text.DocumentException;
import com.zep.bankingkafka.models.Transaction;
import com.zep.bankingkafka.services.impl.BankStatement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/bankstatement")
@AllArgsConstructor
public class TransactionController {
  private BankStatement bankStatement;

  @GetMapping("/generate")
  public List<Transaction> generateBankStatement(@RequestParam String accountNumber,@RequestParam String startDate,@RequestParam String endDate) throws DocumentException, FileNotFoundException {
      return  bankStatement.generateStatement(accountNumber,startDate,endDate);

  }
}
