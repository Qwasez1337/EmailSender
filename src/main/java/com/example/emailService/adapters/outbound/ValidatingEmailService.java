package com.example.emailService.adapters.outbound;

import com.example.emailService.application.ports.SenderService;
import com.example.emailService.domain.ProblemMessage;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service("validatingEmailService")
// Мы так же наследуемся от SenderService, сохраняя тип
public class ValidatingEmailService implements SenderService {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private final SenderService emailService;

    public ValidatingEmailService(SenderService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void send(String recipient, ProblemMessage message) {
        if (!isValidEmail(recipient)) {
            throw new IllegalArgumentException("Invalid email address: " + recipient);
        }
        emailService.send(recipient, message);
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
