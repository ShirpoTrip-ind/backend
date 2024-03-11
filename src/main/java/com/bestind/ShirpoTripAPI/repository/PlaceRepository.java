package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.model.Place;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

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

@Component
public interface PlaceRepository extends MongoRepository<Place, String> {
    @Query("{placeId: ?0}")
    Place findPlace(String placeId);

    @Query("{title: ?0}")
    List<Place> findSame(String title);

    @Query("{$and: [{placeId: ?0}, {title : ?1}, {description : ?2}, {location : ?8}, {relaxType : ?9}, {tags : ?10}, {$or: [{feedback : ?3}, {feedback: {$exists: false}} ]}, {$or: [{visitorAge : ?4}, {visitorAge: {$exists: false}} ]}, {$or: [{child : ?5}, {child: {$exists: false}} ]}, {$or: [{url : ?6}, {url: {$exists: false}} ]}, {$or: [{averagePrice : ?7}, {averagePrice: {$exists: false}} ]}, {$or: [{contactInfo : ?11}, {contactInfo: {$exists: false}} ]}, {$or: [{scheduleFrom : ?12}, {scheduleFrom: {$exists: false}} ]}, {$or: [{scheduleTo : ?13}, {scheduleTo: {$exists: false}} ]} ]}")
    Place putPlace(String place_id, String description, String feedback, Integer visitorAge, boolean child, URL url, Float averagePrice, String location, RelaxType relaxType, List<String> tags, String contactInfo, String scheduleFrom, String scheduleTo);
}
