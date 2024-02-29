package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

String okMsg = "All OK";
String eMsg = "Not OK";

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok().body(okMsg);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(eMsg);
        }
    }
}

@RestController
@RequestMapping("/baseURL/place")
public class PlaceController {

    @GetMapping
    public ResponseEntity getPlace() {
        try {
            return ResponseEntity.ok().body(okMsg);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(eMsg);
        }
    }

    @PostMapping
    public ResponseEntity postPlace() {
        // наверное надо как-то обработать этот place
        try {
            return ResponseEntity.created(URI.create("/baseURL/" + place.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(eMsg);
        }

    }
}

@RestController
@GetMapping("/baseURL/places")
public ResponseEntity getPlaces() {
    try {
        return ResponseEntity.ok().body(okMsg);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(eMsg);
    }
}