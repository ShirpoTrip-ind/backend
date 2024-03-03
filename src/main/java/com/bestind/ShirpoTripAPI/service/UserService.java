package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.LoginUserRequest;
import com.bestind.ShirpoTripAPI.entity.RegisterUserRequest;
import com.bestind.ShirpoTripAPI.model.User;
import com.bestind.ShirpoTripAPI.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final ObjectMapper objectMapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    public UserService(UserRepository userRepo, ObjectMapper objectMapper) {
        this.userRepo = userRepo;
        this.objectMapper = objectMapper;
    }

    public String loginUser(LoginUserRequest loginUserRequest) throws JsonProcessingException {
        final User user = userRepo.findUser(
                loginUserRequest.getLogin(),
                loginUserRequest.getPassword()
        );
        final String str = objectMapper.writeValueAsString(user);

        return objectMapper.writeValueAsString(userRepo.findUser(
                loginUserRequest.getLogin(),
                loginUserRequest.getPassword()
        ));
    }

    public String registerUser(RegisterUserRequest registerUserRequest) throws JsonProcessingException {
        System.out.print(objectMapper.writeValueAsString(registerUserRequest));
        User user = objectMapper.readValue(objectMapper.writeValueAsString(registerUserRequest), User.class);
        mongoTemplate.insert(user);
        return user.toString();
    }
}
