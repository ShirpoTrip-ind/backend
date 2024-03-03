package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.exception.PlaceExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.bestind.ShirpoTripAPI.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepo;

    @GetMapping
    public ResponseEntity getPlace() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }

    @PostMapping
    public ResponseEntity postPlace(@RequestBody PlaceRequest placeRequest) throws PlaceExistException {

        if (duplicateException(placeRequest)) {
            throw new PlaceExistException("Got exception");
        }

        PlaceRequest createdPlace = new PlaceRequest();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);

    }

    private boolean duplicateException(PlaceRequest placeRequest) {
        // проверка на дубль
        return false;
    }

    @ExceptionHandler(PlaceExistException.class)
    public ResponseEntity handleException(PlaceExistException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

}