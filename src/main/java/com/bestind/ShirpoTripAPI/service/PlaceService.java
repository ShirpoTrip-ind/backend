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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final ObjectMapper mapper;
    private static final Logger fileLogger = LoggerFactory.getLogger(PlaceService.class);
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
            fileLogger.trace("Getting places");
            return mapper.writeValueAsString(placeRepository.findAll());
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad Request in getPlaces");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in getPlaces");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong in getPlaces");
            throw new PizdecException();
        }
    }
    public String getPlace(String placeId) throws ShirpoException {
        try {
            fileLogger.trace("Getting place");
            return mapper.writeValueAsString(placeRepository.findPlace(placeId));
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad Request in getPlace");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in getPlace");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong in getPlace");
            throw new PizdecException();
        }
    }
    public String postPlace(PostPlaceRequest postPlaceRequest) throws ShirpoException {
        try {
            fileLogger.trace(mapper.writeValueAsString(postPlaceRequest), "Posting place");
            System.out.println(mapper.writeValueAsString(postPlaceRequest));
            Place place = mapper.readValue(mapper.writeValueAsString(postPlaceRequest), Place.class);
            if (!placeRepository.findSame(place.getTitle()).isEmpty()) {
                throw new PlaceExistsException();
            }
            placeRepository.insert(place);
            return mapper.writeValueAsString(place);
        } catch (PlaceExistsException e) {
            fileLogger.error("Place doesn't exist in postPlace");
            throw e;
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad Request in postPlace");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in postPlace");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong in postPlace");
            throw new PizdecException();
        }
    }

    public String putPlace(String placeId, PutPlaceRequest putPlaceRequest) throws ShirpoException {
        try {
            fileLogger.trace(mapper.writeValueAsString(putPlaceRequest), "Putting place");
            Place updatedPlace = mapper.readValue(mapper.writeValueAsString(putPlaceRequest), Place.class);
            if (!Objects.equals(placeId, putPlaceRequest.getPlaceId()))
                throw new PlaceIdNotEqualsException();
            final Place oldPlace = placeRepository.findPlace(placeId);
            if (oldPlace == null)
                throw new PlaceNotFoundException();

            final Place newPlace = new Place(
                    oldPlace.get_id(),
                    placeId,
                    putPlaceRequest.getTitle(),
                    putPlaceRequest.getDescription(),
                    putPlaceRequest.getFeedback(),
                    putPlaceRequest.getVisitorAge(),
                    putPlaceRequest.isChild(),
                    putPlaceRequest.getUrl(),
                    putPlaceRequest.getAveragePrice(),
                    putPlaceRequest.getLocation(),
                    putPlaceRequest.getRelaxType(),
                    putPlaceRequest.getTags(),
                    putPlaceRequest.getContactInfo(),
                    putPlaceRequest.getScheduleFrom(),
                    putPlaceRequest.getScheduleTo()
            );

            placeRepository.save(newPlace);
            return mapper.writeValueAsString(updatedPlace);
        } catch (JsonProcessingException e) {
            fileLogger.error("Bad Request in putPlace");
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in putPlace");
            throw new MongoCrashException();
        } catch (PlaceIdNotEqualsException e) {
            fileLogger.error("Different Id while putting place");
            throw e;
        } catch (Exception e) {
            fileLogger.error("Something went wrong in putPlace");
            throw new PizdecException();
        }
    }

    public String deletePlace(String placeId) throws ShirpoException {
        try {
            fileLogger.trace("Deleting place with id = {}", placeId);
            final Place place = placeRepository.findPlace(placeId);
            if (place == null)
                throw new PlaceNotFoundException();
            placeRepository.delete(place);
            return "OK";
        } catch (PlaceNotFoundException e) {
            fileLogger.error("Didn't find the place while deleting");
            throw e;
        } catch (MongoException e) {
            fileLogger.error("Mongo crashed in deletePlace");
            throw new MongoCrashException();
        } catch (Exception e) {
            fileLogger.error("Something went wrong in deletePlace");
            throw new PizdecException();
        }
    }
}
