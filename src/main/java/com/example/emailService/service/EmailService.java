package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
//    @Autowired
//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    public void sendEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("AIPolozkov@1cbit.ru"); // Служебная почта
        message.setFrom("q629536@yandex.ru"); // Отправитель
        message.setSubject("Новый запрос от клиента");
        message.setText(buildEmailBody(request));

        mailSender.send(message);
    }

    private String buildEmailBody(EmailRequest request) {
        return "Организация: " + request.getOrganizationName() + "\n" +
                "ИНН: " + request.getInn() + "\n" +
                "Вопрос: " + request.getQuestion();
    }
}
