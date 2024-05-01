package com.zep.bankingkafka.services;
import com.zep.bankingkafka.dtos.BankResponse;
import com.zep.bankingkafka.dtos.UserRequest;
public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
