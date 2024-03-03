package com.bestind.ShirpoTripAPI.exception.user;

import org.springframework.http.HttpStatusCode;

public class UserAlreadyExistsException extends UserException{
    public UserAlreadyExistsException() {
        super(HttpStatusCode.valueOf(400), "User with this login already exists.");
    }
}
