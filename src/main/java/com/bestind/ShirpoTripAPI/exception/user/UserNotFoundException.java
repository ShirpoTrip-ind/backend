package com.bestind.ShirpoTripAPI.exception.user;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends ShirpoException {
    public UserNotFoundException() {
        super(HttpStatusCode.valueOf(404), "User not found in database.\n");
    }
}
