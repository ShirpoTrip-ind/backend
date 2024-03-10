package com.bestind.ShirpoTripAPI.exception.place;

import org.springframework.http.HttpStatusCode;

public class PlaceBadRequestException extends PlaceException {
    public PlaceBadRequestException() {
        super(HttpStatusCode.valueOf(400), "Request has bad input data. API can't create this user");
    }
}
