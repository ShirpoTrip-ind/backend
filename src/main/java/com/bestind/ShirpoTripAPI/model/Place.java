package com.bestind.ShirpoTripAPI.model;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
    String title;
    String description;
    String feedback;
    Optional<Integer> visitor_age;
    Optional<URL> url;
    Optional<Float> average_price;
    String location;
    RelaxType relaxType;
    List<String> tags;
    Optional<String> contact_info;
    Optional<DateTimeFormatter> schedule;

    public Place(String title, String description, String feedback,
                 Integer visitor_age, URL url, Float average_price, String location,
                 RelaxType relaxType, List<String> tags, String contact_info, DateTimeFormatter schedule) {

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
