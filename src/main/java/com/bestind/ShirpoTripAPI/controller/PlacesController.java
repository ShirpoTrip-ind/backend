package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.entity.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceException;
import com.bestind.ShirpoTripAPI.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/places")
public class PlacesController {
    private final PlaceService placeService;
    @Autowired
    public PlacesController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @GetMapping

    public ResponseEntity getPlaces() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }

    @PutMapping
    public ResponseEntity putPlace(@RequestBody PutPlaceRequest putplaceRequest) throws PlaceException {
        return ResponseEntity.ok().body(placeService.putPlace(putplaceRequest));
    }

    @ExceptionHandler({PlaceException.class, Exception.class})
    public ResponseEntity handleException(PlaceException e) {
        try {
            return e.returnError();
        } catch (Exception exc) {
            return new PlaceBadRequestException().returnError();
        }
    }
}