package com.bestind.ShirpoTripAPI.exception.user;

import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super(HttpStatusCode.valueOf(404), "User not found in database.\n");
    }
}
