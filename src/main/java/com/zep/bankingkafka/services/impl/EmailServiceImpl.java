package com.zep.bankingkafka.services.impl;

import com.zep.bankingkafka.dtos.EmailDetails;
import com.zep.bankingkafka.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private  String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
       try {
           SimpleMailMessage mailMessage=new SimpleMailMessage();
           mailMessage.setFrom(senderEmail);
           mailMessage.setTo(emailDetails.getRecipient());
           mailMessage.setText(emailDetails.getMessageBody());
           mailMessage.setSubject(emailDetails.getSubject());
           javaMailSender.send(mailMessage);
           System.out.println("Mail sent successfully");
       }catch (MatchException e){
           throw new RuntimeException(e);
       }
    }
}
