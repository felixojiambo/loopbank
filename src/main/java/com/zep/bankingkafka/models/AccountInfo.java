package com.zep.bankingkafka.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {
    private  String accountNumber;
    private  String accountName;
    private  String  accountBalance;
}
