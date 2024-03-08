package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    @Query("{login : ?0, password : ?1}")
    Optional<User> findUser(String login, String password);
}



