package com.danilove.emailservice.application;

import com.danilove.emailservice.adapters.EmailSenderGateway;
import com.danilove.emailservice.core.usecases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway gateway) {
        this.emailSenderGateway = gateway;
    }

    @Override
    public void send(String to, String subject, String body) {
        this.emailSenderGateway.send(to, subject, body);
    }
}
