package com.bestind.ShirpoTripAPI.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Entity
@Value
@NoArgsConstructor(force = true)
public class LoginUserRequest {
    @NonNull
    String login;
    @NonNull
    String password;
}
