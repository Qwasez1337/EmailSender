package com.example.emailService.application.services;

import com.example.emailService.application.ports.MessageParser;
import com.example.emailService.application.ports.SenderService;
import com.example.emailService.domain.ProblemMessage;
import com.example.emailService.domain.ProblemRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProblemService {
    private final SenderService senderService;
    private final HashMap<String, String> recipients;
    private final MessageParser parser;

    public ProblemService(@Qualifier("validatingEmailService") SenderService senderService,
                          @Qualifier("textMessageParser") MessageParser parser) {
        this.senderService = senderService;
        this.parser = parser;
        recipients = new HashMap<>();
        recipients.put("cul", "leasing@1cbit.ru");
        recipients.put("uz", "uz@1cbit.ru");
        recipients.put("test", "AIPolozkov@1cbit.ru");
    }

    public void reportProblem(ProblemRequest problem) {
        String recipient = recipients.get(problem.getServiceId());
        ProblemMessage message = parser.parse(problem);
        senderService.send(recipient, message);
    }
}
