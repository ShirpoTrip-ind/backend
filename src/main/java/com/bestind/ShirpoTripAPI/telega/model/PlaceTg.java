package com.bestind.ShirpoTripAPI.telega.model;

import com.bestind.ShirpoTripAPI.model.enums.RelaxType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//все три аннотации должны реализовать все методы get и set автоматически, + реализоватьэквивалентность по всем полям
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("place")
@Document(collection = "place_tg")
public class PlaceTg {
    @Id
    @JsonIgnore
    @NonNull
    ObjectId _id;

    @NonNull
    @JsonProperty("place_id")
    String placeId;

    @NonNull
    @EqualsAndHashCode.Include
    @JsonProperty("title")
    String title;

    @NonNull
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
    @NonNull
    @JsonProperty("location")
    String location;

    @NonNull
    @JsonProperty("relax_type")
    RelaxType relaxType;

    @NonNull
    @JsonProperty("tags")
    List<String> tags;

    @JsonProperty("contact_info")
    String contactInfo;

    @JsonProperty("schedule_from")
    String scheduleFrom;

    @JsonProperty("schedule_to")
    String scheduleTo;
}
