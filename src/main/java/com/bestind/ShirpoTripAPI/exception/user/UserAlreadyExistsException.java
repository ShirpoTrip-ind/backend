package com.bestind.ShirpoTripAPI.exception.user;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class UserAlreadyExistsException extends ShirpoException {
    public UserAlreadyExistsException() {
        super(HttpStatusCode.valueOf(400), "User with this login already exists.");
    }
}
