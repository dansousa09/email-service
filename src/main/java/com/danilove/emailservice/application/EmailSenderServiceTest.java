package com.danilove.emailservice.application;

import com.danilove.emailservice.adapters.EmailSenderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class EmailSenderServiceTest {

    private EmailSenderGateway emailSenderGateway;
    private EmailSenderService emailSenderService;

    @BeforeEach
    void setUp() {
        emailSenderGateway = Mockito.mock(EmailSenderGateway.class);
        emailSenderService = new EmailSenderService(emailSenderGateway);
    }

    @Test
    void sendEmailSuccessfully() {
        String to = "test@example.com";
        String subject = "Test Subject";
        String body = "Test Body";

        emailSenderService.send(to, subject, body);

        verify(emailSenderGateway, times(1)).send(to, subject, body);
    }

    @Test
    void sendEmailWithEmptySubject() {
        String to = "test@example.com";
        String subject = "";
        String body = "Test Body";

        emailSenderService.send(to, subject, body);

        verify(emailSenderGateway, times(1)).send(to, subject, body);
    }

    @Test
    void sendEmailWithEmptyBody() {
        String to = "test@example.com";
        String subject = "Test Subject";
        String body = "";

        emailSenderService.send(to, subject, body);

        verify(emailSenderGateway, times(1)).send(to, subject, body);
    }

    @Test
    void sendEmailWithNullRecipient() {
        String to = null;
        String subject = "Test Subject";
        String body = "Test Body";

        emailSenderService.send(to, subject, body);

        verify(emailSenderGateway, times(1)).send(to, subject, body);
    }
}