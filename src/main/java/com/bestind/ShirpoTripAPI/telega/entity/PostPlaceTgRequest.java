package com.bestind.ShirpoTripAPI.telega.entity;

import com.bestind.ShirpoTripAPI.model.enums.RelaxType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.net.URL;
import java.util.List;
import java.util.UUID;

//все три аннотации должны реализовать все методы get и set автоматически, + реализоватьэквивалентность по всем полям
@EqualsAndHashCode(callSuper = false)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("place")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostPlaceTgRequest {
    @Id
    @JsonIgnore
    @NonNull
    ObjectId _id = new ObjectId();

    @NonNull
    @JsonProperty("place_id")
    String placeId = String.valueOf(UUID.randomUUID());

    @EqualsAndHashCode.Include
    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    @JsonProperty("feedback")
    String feedback;

    @JsonProperty("visitor_age")
    Integer visitorAge;

    @JsonProperty("child")
    boolean child;

    @EqualsAndHashCode.Include
    @JsonProperty("url")
    String url;

    @JsonProperty("average_price")
    Float averagePrice;

    @EqualsAndHashCode.Include
    @JsonProperty("location")
    String location;

    @JsonProperty("relax_type")
    RelaxType relaxType;

    @JsonProperty("tags")
    List<String> tags;

    @JsonProperty("contact_info")
    String contactInfo;

    @JsonProperty("schedule_from")
    String scheduleFrom;

    @JsonProperty("schedule_to")
    String scheduleTo;
}
