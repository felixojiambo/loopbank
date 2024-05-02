package com.zep.bankingkafka.controllers;
import com.zep.bankingkafka.dtos.*;
import com.zep.bankingkafka.services.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
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
            description = "Creating new user  and assigning account number"
    )
    @ApiResponse()
    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return  userService.createAccount(userRequest);
    }
    @GetMapping("/balanceEnquiry")
    public  BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return  userService.balanceEnquiry(request);
    }

    @GetMapping("/nameEnquiry")
    public  String nameEnquiry(@RequestBody EnquiryRequest request)
    {
        return  userService.nameEnquiry(request);
    }
    @PostMapping("/credit")
    public  BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }
    @PostMapping("/debit")
    public  BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }
    @PostMapping("/transfer")
    public  BankResponse transfer(@RequestBody TransferRequest request){
        return  userService.transfer(request);
    }
}
