package com.example.emailService.application.services;

import com.example.emailService.application.ports.MessageParser;
import com.example.emailService.domain.ProblemMessage;
import com.example.emailService.domain.ProblemRequest;
import org.springframework.stereotype.Service;

@Service("textMessageParser")
public class TextMessageParser implements MessageParser {

    @Override
    public ProblemMessage parse(ProblemRequest problem) {
        String title = "Новый запрос от клиента";
        String body = "Организация: " + problem.getOrganizationName() + "\n" +
                "ИНН: " + problem.getInn() + "\n" +
                "Вопрос: " + problem.getQuestion();

        return new ProblemMessage(title, body);
    }
}
