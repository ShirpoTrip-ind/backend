package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/places")
@CrossOrigin
public class PlacesController {
    private final PlaceService placeService;
    @Autowired
    PlacesController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @GetMapping
    public ResponseEntity getPlaces() throws ShirpoException {
        return ResponseEntity.ok().body(placeService.getPlaces());
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