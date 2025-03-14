package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailBody emailBody;

    public EmailService(JavaMailSender mailSender, EmailBody emailBody) {
        this.mailSender = mailSender;
        this.emailBody = emailBody;
    }

    public void sendEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("AIPolozkov@1cbit.ru");
        message.setSubject("Новый запрос от клиента");
        message.setText(emailBody.buildEmailBody(request));

        mailSender.send(message);
    }

}
