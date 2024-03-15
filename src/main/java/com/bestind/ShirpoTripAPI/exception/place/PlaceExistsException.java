package com.bestind.ShirpoTripAPI.exception.place;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class PlaceExistsException extends ShirpoException {


    public PlaceExistsException() {
        super(HttpStatusCode.valueOf(400), "Place with this title already exists.");
    }
}