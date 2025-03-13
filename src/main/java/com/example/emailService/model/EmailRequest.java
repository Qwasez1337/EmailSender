package com.example.emailService.model;

import java.util.List;

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
