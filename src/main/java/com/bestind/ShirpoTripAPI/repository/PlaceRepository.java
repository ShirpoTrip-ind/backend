package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.entity.PlaceEntity;
import com.bestind.ShirpoTripAPI.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PlaceRepository extends MongoRepository<PlaceEntity, String> {
    @Query("{place_id : ?0}")
    Optional<Place> findPlace(String place_id);
}
