package com.bestind.ShirpoTripAPI.exception.place;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public abstract class PlaceException extends Exception {
    private final HttpStatusCode statusCode;
    private final String message;

    public PlaceException(HttpStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    public ResponseEntity returnError() {
        return ResponseEntity.status(statusCode).body(message);
    }
}

