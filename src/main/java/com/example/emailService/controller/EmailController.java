package com.example.emailService.controller;

import com.example.emailService.model.EmailRequest;
import com.example.emailService.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        messageService.sendMessage(emailRequest);
        return ResponseEntity.ok("Письмо отправлено!");
    }
}
