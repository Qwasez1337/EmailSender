package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class EmailBody implements TextParser {

    @Override
    public ParsedEmail parse(EmailRequest request) {
        String title = "Новый запрос от клиента";
        String body = "Организация: " + request.getOrganizationName() + "\n" +
                "ИНН: " + request.getInn() + "\n" +
                "Вопрос: " + request.getQuestion();

        return new ParsedEmail(title, body);
    }
}

interface TextParser {
    ParsedEmail parse(EmailRequest request);
}