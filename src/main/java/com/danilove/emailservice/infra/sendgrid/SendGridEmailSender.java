package com.danilove.emailservice.infra.sendgrid;

import com.danilove.emailservice.adapters.EmailSenderGateway;
import com.danilove.emailservice.core.exceptions.EmailServiceException;
import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SendGridEmailSender implements EmailSenderGateway {
    private final Logger logger = Logger.getLogger(SendGridEmailSender.class.getName());

    private final SendGrid sg = new SendGrid("SENDGRID_API_KEY");

    @Override
    public void send(String to, String subject, String body) {
        Email from = new Email("sender@mail.com");
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, toEmail, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            logger.info(response.getBody());
        } catch (Exception e) {
            throw new EmailServiceException("Error sending email", e);
        }
    }
}
