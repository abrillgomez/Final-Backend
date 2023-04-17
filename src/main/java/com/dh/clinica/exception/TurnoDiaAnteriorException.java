package com.dh.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurnoDiaAnteriorException extends Exception{
    public TurnoDiaAnteriorException(String message) {
        super(message);
    }
}