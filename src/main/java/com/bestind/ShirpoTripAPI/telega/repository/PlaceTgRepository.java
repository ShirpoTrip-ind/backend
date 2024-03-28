package com.bestind.ShirpoTripAPI.telega.repository;

import com.bestind.ShirpoTripAPI.telega.model.PlaceTg;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlaceTgRepository extends MongoRepository<PlaceTg, String> {
    @Query("{placeId: ?0}")
    PlaceTg findPlace(String placeId);
    @Query("{title: ?0}")
    List<PlaceTg> findSame(String title);
}
