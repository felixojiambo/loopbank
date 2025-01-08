package com.zep.bankingkafka.controllers;

import com.zep.bankingkafka.dtos.*;
import com.zep.bankingkafka.services.UserService;
import com.zep.bankingkafka.utils.AccountUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Account Management APIs", description = "APIs for managing user accounts")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Create New User Account",
            description = "Creates a new user account and assigns an account number"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User account created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user data provided")
    })
    @PostMapping
    public ResponseEntity<BankResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        BankResponse response = userService.createAccount(userRequest);
        if (response.getResponseCode().equals(AccountUtils.ACCOUNT_CREATION_SUCCESS)) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else if (response.getResponseCode().equals(AccountUtils.ACCOUNT_EXISTS_CODE)) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Retrieve User Account Balance",
            description = "Retrieves the balance of a user account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Balance retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{accountNumber}/balance")
    public ResponseEntity<BankResponse> getBalanceEnquiry(
            @PathVariable("accountNumber") String accountNumber) {
        EnquiryRequest request = EnquiryRequest.builder()
                .accountNumber(accountNumber)
                .build();
        BankResponse response = userService.balanceEnquiry(request);
        if (response.getResponseCode().equals(AccountUtils.ACCOUNT_FOUND_CODE)) {
            return ResponseEntity.ok(response);
        } else if (response.getResponseCode().equals(AccountUtils.ACCOUNT_NOT_EXISTS_CODE)) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Retrieve User Name",
            description = "Retrieves the name associated with a user account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{accountNumber}/name")
    public ResponseEntity<NameEnquiryResponse> getNameEnquiry(
            @PathVariable("accountNumber") String accountNumber) {
        EnquiryRequest request = EnquiryRequest.builder()
                .accountNumber(accountNumber)
                .build();
        String name = userService.nameEnquiry(request);
        if (name != null && !name.isEmpty()) {
            NameEnquiryResponse response = NameEnquiryResponse.builder()
                    .name(name)
                    .build();
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Credit User Account",
            description = "Credits an amount to a user account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account credited successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping("/{accountNumber}/credit")
    public ResponseEntity<BankResponse> creditAccount(
            @PathVariable("accountNumber") String accountNumber,
            @Valid @RequestBody CreditDebitRequest request) {
        request.setAccountNumber(accountNumber);
        BankResponse response = userService.creditAccount(request);
        if (response.getResponseCode().equals(AccountUtils.ACCOUNT_CREDITED_SUCCESS)) {
            return ResponseEntity.ok(response);
        } else if (response.getResponseCode().equals(AccountUtils.ACCOUNT_NOT_EXISTS_CODE)) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
            summary = "Debit User Account",
            description = "Debits an amount from a user account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account debited successfully"),
            @ApiResponse(responseCode = "400", description = "Insufficient balance or invalid request"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @PostMapping("/{accountNumber}/debit")
    public ResponseEntity<BankResponse> debitAccount(
            @PathVariable("accountNumber") String accountNumber,
            @Valid @RequestBody CreditDebitRequest request) {
        request.setAccountNumber(accountNumber);
        BankResponse response = userService.debitAccount(request);
        switch (response.getResponseCode()) {
            case AccountUtils.ACCOUNT_DEBITED_SUCCESS:
                return ResponseEntity.ok(response);
            case AccountUtils.INSUFFICIENT_BALANCE_CODE:
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case AccountUtils.ACCOUNT_NOT_EXISTS_CODE:
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Transfer Funds Between Accounts",
            description = "Transfers funds from one user account to another"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funds transferred successfully"),
            @ApiResponse(responseCode = "400", description = "Insufficient balance or invalid request"),
            @ApiResponse(responseCode = "404", description = "Source or destination account not found")
    })
    @PostMapping("/transfer")
    public ResponseEntity<BankResponse> transferFunds(
            @Valid @RequestBody TransferRequest request) {
        BankResponse response = userService.transfer(request);
        switch (response.getResponseCode()) {
            case AccountUtils.ACCOUNT_TRANSFER_SUCCESS:
                return ResponseEntity.ok(response);
            case AccountUtils.INSUFFICIENT_BALANCE_CODE:
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case AccountUtils.ACCOUNT_NOT_EXISTS_CODE:
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}