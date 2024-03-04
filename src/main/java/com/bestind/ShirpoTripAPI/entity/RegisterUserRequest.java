package com.bestind.ShirpoTripAPI.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Value
@NoArgsConstructor(force = true)
public class RegisterUserRequest {
    @Id
    @NonNull
    @JsonIgnore
    ObjectId _id = new ObjectId();
    @NonNull
    String userId = String.valueOf(UUID.randomUUID());
    @NonNull
    String password;
    @NonNull
    String login;
}
