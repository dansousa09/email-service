package com.danilove.emailservice.adapters;

public interface EmailSenderGateway {
    void send(String to, String subject, String body);
}
