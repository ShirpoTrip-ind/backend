package com.bestind.ShirpoTripAPI.exception.place;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class PlaceNotFoundException extends ShirpoException {
    public PlaceNotFoundException() {
        super(HttpStatusCode.valueOf(404), "Can't find this place.");
    }
}
