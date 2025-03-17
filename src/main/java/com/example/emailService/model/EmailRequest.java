package com.example.emailService.model;

import java.util.List;

// ClientData
public class EmailRequest {
    private String organizationName;
    private String inn;
    private String question;

    public String getOrganizationName() {
        return organizationName;
    }

    public String getInn() {
        return inn;
    }

    public String getQuestion() {
        return question;
    }
}
// CulToMailData
// EmailCulRequest -Mapping-> EmailWarm {body, title}
// EmailUzRequest -Mapping-> EmailWarm ->
