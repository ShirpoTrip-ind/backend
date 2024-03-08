package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.LoginUserRequest;
import com.bestind.ShirpoTripAPI.entity.RegisterUserRequest;
import com.bestind.ShirpoTripAPI.exception.user.UserAlreadyExistsException;
import com.bestind.ShirpoTripAPI.exception.user.UserBadRequestException;
import com.bestind.ShirpoTripAPI.exception.user.UserException;
import com.bestind.ShirpoTripAPI.exception.user.UserNotFoundException;
import com.bestind.ShirpoTripAPI.model.User;
import com.bestind.ShirpoTripAPI.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final ObjectMapper mapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    public UserService(UserRepository userRepo, ObjectMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public String loginUser(LoginUserRequest loginUserRequest) throws UserException {
        try {
            final Optional<User> user = userRepo.findUser(
                    loginUserRequest.getLogin(),
                    loginUserRequest.getPassword()
            );

            if (user.isEmpty())
                throw new UserNotFoundException();

            return mapper.writeValueAsString(user.get());
        } catch (JsonProcessingException e) {
            throw new UserBadRequestException();
        }
    }

    public String registerUser(RegisterUserRequest registerUserRequest) throws UserException {
        try {
            final User user = mapper.readValue(mapper.writeValueAsString(registerUserRequest), User.class);

            if (userRepo.findUser(user.getLogin(), user.getPassword()).isPresent())
                throw new UserAlreadyExistsException();

            userRepo.insert(user);
            return mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new UserBadRequestException();
        }
    }
}
