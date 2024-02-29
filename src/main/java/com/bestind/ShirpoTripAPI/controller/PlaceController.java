package com.bestind.ShirpoTripAPI.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @GetMapping
    public ResponseEntity getPlace() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }

    @PostMapping
    public ResponseEntity postPlace(@RequestBody Place place) {
        Place createdPlace = new Place();
        try {
            return ResponseEntity.status(HttpStatusCode.CREATED).body(createdPlace);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        } catch (CustomException e) { //проверка на дублирование
            return ResponseEntity.conflict().bodyMessage(e.getMessage());
        }
    }
}