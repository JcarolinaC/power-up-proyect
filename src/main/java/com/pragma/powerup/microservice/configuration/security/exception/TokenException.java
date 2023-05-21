package com.pragma.powerup.microservice.configuration.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenException extends AuthenticationException {
    public TokenException() {
        super("A problem with the token has occurred");
    }
}
