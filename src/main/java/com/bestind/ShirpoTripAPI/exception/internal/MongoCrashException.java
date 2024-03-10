package com.bestind.ShirpoTripAPI.exception.internal;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class MongoCrashException extends ShirpoException {

    public MongoCrashException() {
        super(HttpStatusCode.valueOf(500), "Mongo's mum is dead -_-");
    }
}
