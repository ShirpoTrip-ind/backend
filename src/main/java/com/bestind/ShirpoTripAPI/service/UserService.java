package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.user.LoginUserRequest;
import com.bestind.ShirpoTripAPI.entity.user.RegisterUserRequest;
import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.internal.MongoCrashException;
import com.bestind.ShirpoTripAPI.exception.internal.PizdecException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.exception.user.UserAlreadyExistsException;
import com.bestind.ShirpoTripAPI.exception.user.UserNotFoundException;
import com.bestind.ShirpoTripAPI.model.User;
import com.bestind.ShirpoTripAPI.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final ObjectMapper mapper;
    private static final Logger fileLogger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo, ObjectMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public String loginUser(LoginUserRequest loginUserRequest) throws ShirpoException {
        try {
            fileLogger.trace("{} wants to enter the system", mapper.writeValueAsString(loginUserRequest));
            final Optional<User> user = userRepo.findUser(
                    loginUserRequest.getLogin(),
                    loginUserRequest.getPassword()
            );

            if (user.isEmpty())
                throw new UserNotFoundException();

            return mapper.writeValueAsString(user.get());
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad request in loginUser");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in loginUser");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong while entering");
            throw new PizdecException();
        }
    }

    public String registerUser(RegisterUserRequest registerUserRequest) throws ShirpoException {
        try {
            fileLogger.trace("{} wants to register in the system", mapper.writeValueAsString(registerUserRequest));
            final User user = mapper.readValue(mapper.writeValueAsString(registerUserRequest), User.class);

            if (userRepo.findUser(user.getLogin(), user.getPassword()).isPresent())
                throw new UserAlreadyExistsException();

            userRepo.insert(user);
            return mapper.writeValueAsString(user);
        } catch (UserAlreadyExistsException e) {
            fileLogger.error("User already exists");
            throw new UserAlreadyExistsException();
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad request in registerUser");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in registerUser");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong while registering");
            throw new PizdecException();
        }
    }
}
