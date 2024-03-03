package com.bestind.ShirpoTripAPI.entity;

import jakarta.persistence.Entity;
import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Value
public class RegisterUserRequest {
    @Id
    ObjectId _id = new ObjectId();
    String userId = String.valueOf(UUID.randomUUID());
    String password;
    String login;
}
