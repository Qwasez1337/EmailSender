package com.example.emailService.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender implements MessageSender{
    JavaMailSender mailSender;

    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(ParsedMessage parsedEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("AIPolozkov@1cbit.ru");
        message.setSubject(parsedEmail.title());
        message.setText(parsedEmail.body());
        mailSender.send(message);
    }
}
