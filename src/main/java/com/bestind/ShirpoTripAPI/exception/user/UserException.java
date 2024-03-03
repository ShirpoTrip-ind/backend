package com.bestind.ShirpoTripAPI.exception.user;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public abstract class UserException extends Exception {
    private final HttpStatusCode statusCode;
    private final String message;

    public UserException(HttpStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    public ResponseEntity returnError() {
        return ResponseEntity.status(statusCode).body(message);
    }
}