package com.bestind.ShirpoTripAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;
enum RelaxType {
    @JsonProperty("active")
    Active,
    @JsonProperty("passive")
    Passive,
    @JsonProperty("any")
    Any
}
//все три аннотации должны реализовать все методы get и set автоматически, + реализоватьэквивалентность по всем полям
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("place")
@Document(collection = "place")
public class Place {
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
    URL url;

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
