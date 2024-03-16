package com.bestind.ShirpoTripAPI.exception.place;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class PlaceIdNotEqualsException extends ShirpoException {


    public PlaceIdNotEqualsException() {
        super(HttpStatusCode.valueOf(400), "PlaceId in params doesn't match placeId in body.");
    }
}