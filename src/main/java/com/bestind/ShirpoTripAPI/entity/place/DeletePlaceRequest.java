package com.bestind.ShirpoTripAPI.entity.place;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@EqualsAndHashCode(callSuper = false)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DeletePlaceRequest {
    @Id
    @NonNull
    ObjectId _id = new ObjectId();;

    @NonNull
    @JsonProperty("place_id")
    String placeId = String.valueOf(UUID.randomUUID());
}
