package com.example.emailService.domain;


import lombok.Getter;

public class ProblemRequest {

    @Getter
    public String serviceId;
    @Getter
    public String contactPhone;
    @Getter
    public String contactEmail;
    @Getter
    public String contactPersonName ;
    @Getter
    public String organizationName;
    @Getter
    public String inn;
    @Getter
    public String question;

}
