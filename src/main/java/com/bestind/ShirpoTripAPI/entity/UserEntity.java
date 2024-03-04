package com.bestind.ShirpoTripAPI.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class UserEntity {
    String place_id;
    String title;
    String description;
    String feedback;
    Optional<Integer> visitor_age;
    Optional<URL> url;
    Optional<Float> average_price;
    String location;
    String relaxType;
    List<String> tags;
    Optional<String> contact_info;
    Optional<DateTimeFormatter> schedule;

    UserEntity(String place_id, String title, String description, String feedback, Optional<Integer> visitor_age,
               Optional<URL> url, Optional<Float> average_price, String location, String relaxType, List<String> tags,
               Optional<String> contact_info, Optional<DateTimeFormatter> schedule) {
        this.place_id = place_id;
        this.title = title;
        this.description = description;
        this.feedback = feedback;
        this.visitor_age = visitor_age;
        this.url = url;
        this.average_price = average_price;
        this.location = location;
        this.relaxType = relaxType;
        this.tags = tags;
        this.contact_info = contact_info;
        this.schedule = schedule;
    }

    String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(this);
    }

    static UserEntity fromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(json, UserEntity.class);
    }

    /*
    @Override
            public String toString() {
            try {
                    return this.toJson();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return null;
                }
        }
     */
}
