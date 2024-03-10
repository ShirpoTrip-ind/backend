package com.bestind.ShirpoTripAPI.exception.internal;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import org.springframework.http.HttpStatusCode;

public class PizdecException extends ShirpoException {
    public PizdecException() {
        super(HttpStatusCode.valueOf(500), "Ya huy znaet che upalo, nesite menya razrabam");
    }
}
