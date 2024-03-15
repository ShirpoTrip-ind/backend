package com.bestind.ShirpoTripAPI.exception.place;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class PlaceBadRequestException extends ShirpoException {
    public PlaceBadRequestException() {
        super(HttpStatusCode.valueOf(400), "Place bad request data.");
    }
}
