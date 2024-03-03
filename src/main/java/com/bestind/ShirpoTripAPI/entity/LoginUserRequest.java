package com.bestind.ShirpoTripAPI.entity;

import jakarta.persistence.Entity;
import lombok.Value;

@Entity
@Value
public class LoginUserRequest {
    String login;
    String password;
}
