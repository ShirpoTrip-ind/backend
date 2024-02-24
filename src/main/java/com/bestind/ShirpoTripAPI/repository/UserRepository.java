package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
