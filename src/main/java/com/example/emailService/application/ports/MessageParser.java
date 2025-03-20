package com.example.emailService.application.ports;

import com.example.emailService.domain.ProblemMessage;
import com.example.emailService.domain.ProblemRequest;

public interface MessageParser {
     ProblemMessage parse(ProblemRequest problem);
}
