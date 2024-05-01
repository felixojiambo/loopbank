package com.zep.bankingkafka.controllers;

import com.zep.bankingkafka.dtos.BankResponse;
import com.zep.bankingkafka.dtos.EnquiryRequest;
import com.zep.bankingkafka.dtos.UserRequest;
import com.zep.bankingkafka.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
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
}
