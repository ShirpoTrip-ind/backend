package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }
}