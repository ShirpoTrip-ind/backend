package com.bestind.ShirpoTripAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlacesController {
    @GetMapping

    public ResponseEntity getPlaces() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }
}