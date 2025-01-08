package com.zep.bankingkafka.controllers;

import com.itextpdf.text.DocumentException;
import com.zep.bankingkafka.dtos.BankStatementResponse;
import com.zep.bankingkafka.models.Transaction;
import com.zep.bankingkafka.services.impl.BankStatement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statements")
@Tag(name = "Bank Statement APIs", description = "APIs for generating and retrieving bank statements")
@RequiredArgsConstructor
public class TransactionController {

    private final BankStatement bankStatement;

    @Operation(
            summary = "Generate Bank Statement",
            description = "Generates a PDF bank statement for a user account within a specified date range"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank statement generated and sent via email successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "500", description = "Error generating bank statement")
    })
    @GetMapping
    public ResponseEntity<BankStatementResponse> generateBankStatement(
            @RequestParam @Pattern(regexp = "\\d+", message = "Account number must be numeric") String accountNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate) {
        try {
            List<Transaction> transactions = bankStatement.generateStatement(accountNumber, startDate, endDate);
            BankStatementResponse response = BankStatementResponse.builder()
                    .message("Bank statement generated and sent via email successfully")
                    .transactions(transactions)
                    .build();
            return ResponseEntity.ok(response);
        } catch (FileNotFoundException | DocumentException e) {
            BankStatementResponse errorResponse = BankStatementResponse.builder()
                    .message("Error generating bank statement")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            BankStatementResponse errorResponse = BankStatementResponse.builder()
                    .message("Account not found or invalid parameters")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}