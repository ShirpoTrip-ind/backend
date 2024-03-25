package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.place.PostPlaceRequest;
import com.bestind.ShirpoTripAPI.entity.place.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.internal.MongoCrashException;
import com.bestind.ShirpoTripAPI.exception.internal.PizdecException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceExistsException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceIdNotEqualsException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceNotFoundException;
import com.bestind.ShirpoTripAPI.model.Place;
import com.bestind.ShirpoTripAPI.repository.PlaceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bestind.ShirpoTripAPI.extension.ExtensionToPlace.PutRequestToPlace;


@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final ObjectMapper mapper;
    @Autowired
    PlaceService(
            PlaceRepository placeRepository,
            ObjectMapper objectMapper
    ) {
        this.placeRepository = placeRepository;
        this.mapper = objectMapper;
    }
    public String getPlaces() throws ShirpoException {
        try {
            return mapper.writeValueAsString(placeRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }
    public String getPlace(String placeId) throws ShirpoException {
        try {
            return mapper.writeValueAsString(placeRepository.findPlace(placeId));
        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }
    public String postPlace(PostPlaceRequest postPlaceRequest) throws ShirpoException {
        try {
            System.out.println(mapper.writeValueAsString(postPlaceRequest));
            Place place = mapper.readValue(mapper.writeValueAsString(postPlaceRequest), Place.class);
            if (!placeRepository.findSame(place.getTitle()).isEmpty()) {
                throw new PlaceExistsException();
            }
            placeRepository.insert(place);
            return mapper.writeValueAsString(place);
        } catch (PlaceExistsException e) {
            throw e;
        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }

    public String putPlace(String placeId, PutPlaceRequest putPlaceRequest) throws ShirpoException {
        try {
            Place updatedPlace = mapper.readValue(mapper.writeValueAsString(putPlaceRequest), Place.class);
            if (!Objects.equals(placeId, putPlaceRequest.getPlaceId()))
                throw new PlaceIdNotEqualsException();
            final Place oldPlace = placeRepository.findPlace(placeId);
            if (oldPlace == null)
                throw new PlaceNotFoundException();

            final Place newPlace = PutRequestToPlace(oldPlace.get_id(), placeId, putPlaceRequest);

            placeRepository.save(newPlace);
            return mapper.writeValueAsString(updatedPlace);
        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (PlaceIdNotEqualsException e) {
            throw e;
        } catch (Exception e) {
            throw new PizdecException();
        }
    }

    public String deletePlace(String placeId) throws ShirpoException {
        try {
            final Place place = placeRepository.findPlace(placeId);
            if (place == null)
                throw new PlaceNotFoundException();
            placeRepository.delete(place);
            return "OK";
        } catch (PlaceNotFoundException e) {
            throw e;
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }
}
