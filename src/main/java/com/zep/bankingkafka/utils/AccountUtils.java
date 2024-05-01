package com.zep.bankingkafka.utils;

import javax.xml.transform.sax.SAXResult;
import java.time.Year;

public class AccountUtils {

    public  static  String generateAccountNumber(){
        //generating account number//update should have county 2 letters,year and 6digits
        Year currentYear= Year.now();
        int min=100000;
        int max=999999;
        //generate random number between min and max
        int  randNumber=(int)Math.floor(Math.random()*(max-min+1)+min);
        //convert current year and random number to string
        String year=String.valueOf(currentYear);
        String  randomNumber=String.valueOf(randNumber);
        StringBuilder accountNumber=new StringBuilder();
        return accountNumber.append(year).append(randomNumber).toString();
    }
    public  static final String ACCOUNT_CREATION_SUCCESS="002";
    public   static  final  String ACCOUNT_CREATION_SUCCESS_MESSAGE="Account successfully created";
    public  static  final  String ACCOUNT_EXISTS_CODE="001";
    public  static  final  String ACCOUNT_EXISTS_MESSAGE="A user with the same email has an account created";
    public  static  final  String ACCOUNT_NOT_EXISTS_CODE="003";
    public  static  final  String ACCOUNT_NOT_EXISTS_MESSAGE="Account does not exist";
    public  static  final  String ACCOUNT_FOUND_CODE="004";
    public  static  final  String ACCOUNT_FOUND_SUCCESS="User account found";

}
