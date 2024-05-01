package com.zep.bankingkafka.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {
    private  String firstName;
    private  String lastName;
    private  String otherName;
    private String gender;
    private  String address;
    private  String county;
    private  String email;
    private  String identificationNumber;
    private  String phoneNumber;
    private String  alternativePhoneNumber;

}
