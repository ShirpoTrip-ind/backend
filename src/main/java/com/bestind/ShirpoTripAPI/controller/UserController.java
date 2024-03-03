package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.entity.LoginUserRequest;
import com.bestind.ShirpoTripAPI.entity.RegisterUserRequest;
import com.bestind.ShirpoTripAPI.repository.UserRepository;
import com.bestind.ShirpoTripAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            return ResponseEntity.ok().body(userService.loginUser(loginUserRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            return ResponseEntity.ok().body(userService.registerUser(registerUserRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not ok");
        }
    }
}