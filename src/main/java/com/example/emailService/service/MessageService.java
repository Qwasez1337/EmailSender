package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class MessageService {

    private final EmailSender mailSender;
    private final MessageBody messageBody;

    public MessageService(EmailSender mailSender, MessageBody messageBody) {
        this.mailSender = mailSender;
        this.messageBody = messageBody;
    }

    public void sendMessage(EmailRequest request) {

        ParsedMessage contentMessage = messageBody.parseText(request);
        //Если это почта, то вызываем метод send() У EmailSender
        mailSender.send(contentMessage);

    }

}

interface MessageSender {
    void send(ParsedMessage parsedMessage);
}


