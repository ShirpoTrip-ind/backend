package com.bestind.ShirpoTripAPI.exception.place;

import org.springframework.http.HttpStatusCode;

public class ServerAccessException extends PlaceException{
    public ServerAccessException() {
        super(HttpStatusCode.valueOf(500), "Internal Server Error.\n");
    }
}
