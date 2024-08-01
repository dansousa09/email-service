package com.danilove.emailservice.core.usecases;

public interface EmailSenderUseCase {
    void send(String to, String subject, String body);
}
