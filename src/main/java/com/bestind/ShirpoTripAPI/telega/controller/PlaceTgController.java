package com.bestind.ShirpoTripAPI.telega.controller;

import com.bestind.ShirpoTripAPI.entity.place.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.telega.entity.PostPlaceTgRequest;
import com.bestind.ShirpoTripAPI.telega.entity.PutPlaceTgRequest;
import com.bestind.ShirpoTripAPI.telega.service.PlaceTgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telega/place")
@CrossOrigin
public class PlaceTgController {
    private final PlaceTgService placeTgService;

    @Autowired
    PlaceTgController(PlaceTgService placeTgService) {
        this.placeTgService = placeTgService;
    }

    @PostMapping
    public ResponseEntity postPlace(@RequestBody PostPlaceTgRequest placeRequest) throws ShirpoException {
        return ResponseEntity.ok().body(placeTgService.postPlace(placeRequest));
    }

    @PutMapping
    public ResponseEntity putPlace(
            @RequestParam(name = "place_id") String placeId,
            @RequestBody PutPlaceTgRequest putplaceRequest
    ) throws ShirpoException {
        return ResponseEntity.ok().body(placeTgService.putPlace(placeId, putplaceRequest));
    }
  
    @DeleteMapping
    public ResponseEntity deletePlace(@RequestParam(name = "place_id") String placeId) throws ShirpoException {
        return ResponseEntity.ok().body(placeTgService.deletePlace(placeId));
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