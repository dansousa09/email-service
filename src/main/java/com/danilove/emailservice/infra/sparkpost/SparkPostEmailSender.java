package com.danilove.emailservice.infra.sparkpost;

import com.danilove.emailservice.adapters.EmailSenderGateway;
import com.danilove.emailservice.core.exceptions.EmailServiceException;
import com.danilove.emailservice.infra.sendgrid.SendGridEmailSender;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SparkPostEmailSender implements EmailSenderGateway {
    private final Logger logger = Logger.getLogger(SendGridEmailSender.class.getName());
    private final Client client = new Client("API_KEY");

    @Override
    public void send(String to, String subject, String body) {
        String sender = "sender@mail.com";

        try {
            client.sendMessage(sender, to, subject, body, "");
            logger.info("Email sent to " + to);
        } catch (SparkPostException e) {
            throw new EmailServiceException("Error sending email", e);
        }
    }
}
