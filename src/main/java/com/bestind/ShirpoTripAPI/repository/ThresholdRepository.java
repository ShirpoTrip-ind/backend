package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.model.Threshold;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThresholdRepository extends MongoRepository<Threshold, String> {
}
