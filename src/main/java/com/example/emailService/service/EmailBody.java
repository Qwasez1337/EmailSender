package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailBody {

    String buildEmailBody(EmailRequest request) {
        return "Организация: " + request.getOrganizationName() + "\n" +
                "ИНН: " + request.getInn() + "\n" +
                "Вопрос: " + request.getQuestion();
    }
}
