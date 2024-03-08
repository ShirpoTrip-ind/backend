package com.bestind.ShirpoTripAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@NoArgsConstructor(force = true)
@Entity
public class User {
    @Id
    @NonNull
    @JsonIgnore
    ObjectId _id;
    @NonNull
    String userId;
    @NonNull
    String password;
    @NonNull
    String login;
}