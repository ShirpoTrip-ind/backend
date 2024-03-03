package com.bestind.ShirpoTripAPI.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface Nullable {
}

enum RelaxType {
    Active,
    Passive
}
//все три аннотации должны реализовать все методы get и set автоматически, + реализоватьэквивалентность по всем полям
@EqualsAndHashCode
@Getter
@Setter

public class Place {
    String place_id;

    @EqualsAndHashCode.Include
    String title;

    String description;
    String feedback;
    Optional<Integer> visitor_age;

    @EqualsAndHashCode.Include
    Optional<URL> url;

    Optional<Float> average_price;
    @EqualsAndHashCode.Include

    String location;
    RelaxType relaxType;
    List<String> tags;
    Optional<String> contact_info;
    Optional<ZonedDateTime> schedule;

    public Place(String title, String description, String feedback,
                 @Nullable Integer visitor_age, @Nullable URL url, @Nullable Float average_price, String location,
                 RelaxType relaxType, List<String> tags, @Nullable String contact_info, @Nullable ZonedDateTime schedule) {

        this.place_id = getPlace_id();
        this.title = title;
        this.description = description;
        this.feedback = feedback;
        this.visitor_age = Optional.ofNullable(visitor_age);
        this.url = Optional.ofNullable(url);
        this.average_price = Optional.ofNullable(average_price);
        this.location = location;
        this.relaxType = relaxType;
        this.tags = tags;
        this.contact_info = Optional.ofNullable(contact_info);
        this.schedule = Optional.ofNullable(schedule);
    }

    String getPlace_id() {
        UUID num_place_id = UUID.randomUUID();
        return num_place_id.toString();
    }
}
