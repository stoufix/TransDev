package com.transdev.busticket.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RessourceNotFound extends Exception {
    public RessourceNotFound(String message) {
        super(message);
    }
}
