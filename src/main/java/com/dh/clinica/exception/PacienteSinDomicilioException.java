package com.dh.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteSinDomicilioException extends Exception {
    public PacienteSinDomicilioException(String message) {
        super(message);
    }
}
