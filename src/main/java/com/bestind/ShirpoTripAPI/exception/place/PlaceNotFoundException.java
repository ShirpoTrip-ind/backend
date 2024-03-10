package com.bestind.ShirpoTripAPI.exception.place;

import org.springframework.http.HttpStatusCode;

public class PlaceNotFoundException extends PlaceException{
    public PlaceNotFoundException() {
        super(HttpStatusCode.valueOf(404), "Place not found in database.\n");
    }
}
