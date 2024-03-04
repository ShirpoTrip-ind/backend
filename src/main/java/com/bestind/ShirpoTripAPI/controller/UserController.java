package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.entity.LoginUserRequest;
import com.bestind.ShirpoTripAPI.entity.RegisterUserRequest;
import com.bestind.ShirpoTripAPI.exception.user.UserBadRequestException;
import com.bestind.ShirpoTripAPI.service.UserService;
import com.bestind.ShirpoTripAPI.exception.user.UserException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity loginUser(@RequestBody LoginUserRequest loginUserRequest) throws UserException {
        return ResponseEntity.ok().body(userService.loginUser(loginUserRequest));
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody RegisterUserRequest registerUserRequest) throws UserException {
        return ResponseEntity.ok().body(userService.registerUser(registerUserRequest));
    }

    @ExceptionHandler({UserException.class, Exception.class})
    public ResponseEntity handleException(UserException e) {
        try {
            return e.returnError();
        } catch (Exception exc) {
            return new UserBadRequestException().returnError();
        }
    }
}