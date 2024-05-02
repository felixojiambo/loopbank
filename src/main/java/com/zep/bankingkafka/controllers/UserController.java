package com.zep.bankingkafka.controllers;

import com.zep.bankingkafka.dtos.*;
import com.zep.bankingkafka.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name="User Account Management APIS")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(
            summary = "Create New User Account",
            description = "Creating new user and assigning account number"
    )
    @ApiResponse(responseCode = "201", description = "Http Status 201 Created")
    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @Operation(
            summary = "Balance Enquiry",
            description = "Enquire the balance of a user account"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @Operation(
            summary = "Name Enquiry",
            description = "Enquire the name of a user account"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

    @Operation(
            summary = "Credit Account",
            description = "Credit an amount to a user account"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    @Operation(
            summary = "Debit Account",
            description = "Debit an amount from a user account"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @Operation(
            summary = "Transfer Funds",
            description = "Transfer funds between user accounts"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/transfer")
    public BankResponse transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
    }
}
