package com.bestind.ShirpoTripAPI.exception.user;

import org.springframework.http.HttpStatusCode;

public class UserBadRequestException extends UserException {
    public UserBadRequestException() {
        super(HttpStatusCode.valueOf(400), "Request has bad input data. API can't create this user");
    }
}
