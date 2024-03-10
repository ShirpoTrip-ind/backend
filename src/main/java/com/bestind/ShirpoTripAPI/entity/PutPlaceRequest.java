package com.bestind.ShirpoTripAPI.entity;

import com.bestind.ShirpoTripAPI.model.RelaxType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.List;


@Entity
@Value
@Getter
@NoArgsConstructor(force = true)
public class PutPlaceRequest {
    @NonNull
    String place_id;
    @NonNull
    String title;
    @NonNull
    String description;
    @NonNull
    String feedback;

    Integer visitor_age;
    URL url;
    Float average_price;

    @NonNull
    String location;
    @NonNull
    RelaxType relaxType;
    @NonNull
    List<String> tags;

    String contact_info;
    ZonedDateTime schedule;
}
