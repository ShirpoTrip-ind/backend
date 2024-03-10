package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.entity.place.PostPlaceRequest;
import com.bestind.ShirpoTripAPI.entity.place.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;
    @Autowired
    PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @GetMapping
    public ResponseEntity getPlace(@RequestParam String placeId) throws ShirpoException {
        return ResponseEntity.ok().body(placeService.getPlace(placeId));
    }
    @PostMapping
    public ResponseEntity postPlace(@RequestBody PostPlaceRequest placeRequest) throws ShirpoException {
        return ResponseEntity.ok().body(placeService.postPlace(placeRequest));
    }

    @PutMapping
    public ResponseEntity putPlace(@RequestBody PutPlaceRequest putplaceRequest) throws ShirpoException {
        return ResponseEntity.ok().body(placeService.putPlace(putplaceRequest));
    }
    @DeleteMapping
    public ResponseEntity putPlace(@RequestBody DeletePlaceRequest deletePlaceRequest) throws ShirpoException {
        return ResponseEntity.ok().body(placeService.putPlace(deletePlaceRequest));

    @ExceptionHandler({ShirpoException.class, Exception.class})
    public ResponseEntity handleException(ShirpoException e) {
        try {
            return e.returnError();
        } catch (Exception exc) {
            return new PlaceBadRequestException().returnError();
        }
    }
}










    //@DeleteMapping
    //public ResponseEntity deletePlace(@RequestBody DeletePlaceRequest deletePlaceRequest) throws UserException {
    //    return ResponseEntity.ok().body(placeService.deletePlace(deletePlaceRequest));
    //}
}