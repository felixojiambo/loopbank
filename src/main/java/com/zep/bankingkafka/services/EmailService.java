package com.zep.bankingkafka.services;

import com.zep.bankingkafka.dtos.EmailDetails;



public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
