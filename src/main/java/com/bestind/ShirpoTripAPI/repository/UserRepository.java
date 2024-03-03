package com.bestind.ShirpoTripAPI.repository;

import com.bestind.ShirpoTripAPI.entity.UserEntity;
import com.bestind.ShirpoTripAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.Document;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    @Query("{login: '?0', password: '?1'}")
    User findUser(String login, String password);
}



