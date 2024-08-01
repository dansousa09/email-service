package com.danilove.emailservice.core.dtos;

public record EmailRequest(String to, String subject, String body) {
}
