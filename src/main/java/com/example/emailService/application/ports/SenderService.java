package com.example.emailService.application.ports;

import com.example.emailService.domain.ProblemMessage;

public interface SenderService {
    void send(String recipient, ProblemMessage message);
}
