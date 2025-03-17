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

        ParsedEmail parsedEmail = emailBody.parse(request);
        EmailSender emailSender = new EmailSender(parsedEmail);
        mailSender.send(emailSender.send());

    }

}

interface MessageSender {
    SimpleMailMessage send();
}

class EmailSender implements MessageSender{
    ParsedEmail parsedEmail;

    public EmailSender(ParsedEmail parsedEmail) {
        this.parsedEmail = parsedEmail;
    }

    @Override
    public SimpleMailMessage send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("AIPolozkov@1cbit.ru");
        message.setSubject(parsedEmail.title());
        message.setText(parsedEmail.body());
        return message;
    }

}

