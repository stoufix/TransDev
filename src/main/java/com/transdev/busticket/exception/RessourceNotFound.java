package com.transdev.busticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFound extends Exception {
    public RessourceNotFound(String message) {
        super(message);
    }
}
