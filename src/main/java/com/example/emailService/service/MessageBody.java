package com.example.emailService.service;

import com.example.emailService.model.EmailRequest;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class MessageBody implements TextParser {

    @Override
    public ParsedMessage parseText(EmailRequest request) {
        String title = "Новый запрос от клиента";
        String body = "Организация: " + request.getOrganizationName() + "\n" +
                "ИНН: " + request.getInn() + "\n" +
                "Вопрос: " + request.getQuestion();

        return new ParsedMessage(title, body);
    }
}

interface TextParser {
    ParsedMessage parseText(EmailRequest request);
}