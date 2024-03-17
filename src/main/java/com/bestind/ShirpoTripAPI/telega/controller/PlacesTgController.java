package com.bestind.ShirpoTripAPI.telega.controller;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.telega.service.PlaceTgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telega/places")
@CrossOrigin
public class PlacesTgController {

    private final PlaceTgService placeTgService;

    @Autowired
    PlacesTgController(PlaceTgService placeTgService) {
        this.placeTgService = placeTgService;
    }

    @GetMapping
    public ResponseEntity getPlaces() throws ShirpoException {
        return ResponseEntity.ok().body(placeTgService.getPlaces());
    }

    @ExceptionHandler({ShirpoException.class, Exception.class})
    public ResponseEntity handleException(ShirpoException e) {
        try {
            return e.returnError();
        } catch (Exception exc) {
            return new PlaceBadRequestException().returnError();
        }
    }
}
