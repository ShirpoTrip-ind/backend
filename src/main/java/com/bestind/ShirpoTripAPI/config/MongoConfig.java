package com.bestind.ShirpoTripAPI.config;

import com.bestind.ShirpoTripAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.concretepage.mongodb")
public class MongoConfig {

    @Autowired
    UserRepository userRepo;
}
