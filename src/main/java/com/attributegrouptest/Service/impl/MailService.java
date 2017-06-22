package com.attributegrouptest.Service.impl;

import com.attributegrouptest.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Created by Noobs on 06/09/2016.
 */
@Service
public class MailService {

    private JavaMailSender mailSender;

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendMail(User toUser, User currentUser) throws MailException, InterruptedException
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toUser.getUsername());
        mailMessage.setFrom("testingspring218@gmail.com");
        mailMessage.setSubject("Rent offer");
        mailMessage.setText("Please contact the user with email " + currentUser.getUsername() + " because that user wants to rent an item");
        mailSender.send(mailMessage);

        
    }

}
