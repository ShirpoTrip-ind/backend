package com.bestind.ShirpoTripAPI.model;

import jakarta.persistence.Entity;
import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Value
@Entity
public class User {
    @Id
    ObjectId _id;
    String userId;
    String password;
    String login;
}