package com.danilove.emailservice.core.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
