package com.bestind.ShirpoTripAPI.exception.user;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class UserBadRequestException extends ShirpoException {
    public UserBadRequestException() {
        super(HttpStatusCode.valueOf(400), "Request has bad input data. API can't create this user");
    }
}
