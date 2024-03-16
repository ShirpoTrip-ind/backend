package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.model.Place;
import com.bestind.ShirpoTripAPI.model.enums.RelaxType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public interface PlaceRepository extends MongoRepository<Place, String> {
    @Query("{placeId: ?0}")
    Place findPlace(String placeId);
    @Query("{title: ?0}")
    List<Place> findSame(String title);
}
