package com.bestind.ShirpoTripAPI.telega.service;

import com.bestind.ShirpoTripAPI.entity.place.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.ShirpoException;
import com.bestind.ShirpoTripAPI.exception.internal.MongoCrashException;
import com.bestind.ShirpoTripAPI.exception.internal.PizdecException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceExistsException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceIdNotEqualsException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceNotFoundException;
import com.bestind.ShirpoTripAPI.model.Place;
import com.bestind.ShirpoTripAPI.telega.entity.PostPlaceTgRequest;
import com.bestind.ShirpoTripAPI.telega.entity.PutPlaceTgRequest;
import com.bestind.ShirpoTripAPI.telega.model.PlaceTg;
import com.bestind.ShirpoTripAPI.telega.repository.PlaceTgRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class PlaceTgService {
    private final PlaceTgRepository placeTgRepository;
    private final ObjectMapper mapper;
    @Autowired
    PlaceTgService(
            PlaceTgRepository placeTgRepository,
            ObjectMapper objectMapper
    ) {
        this.placeTgRepository = placeTgRepository;
        this.mapper = objectMapper;
    }
    public String getPlaces() throws ShirpoException {
        try {
            return mapper.writeValueAsString(placeTgRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }

    public String postPlace(PostPlaceTgRequest postPlaceTgRequest) throws ShirpoException {
        try {
            System.out.println(mapper.writeValueAsString(postPlaceTgRequest));
            PlaceTg placeTg = mapper.readValue(mapper.writeValueAsString(postPlaceTgRequest), PlaceTg.class);
            if (!placeTgRepository.findSame(placeTg.getTitle()).isEmpty()) {
                var f = placeTgRepository.findSame(placeTg.getTitle());
                throw new PlaceExistsException();
            }
            placeTgRepository.insert(placeTg);
            return mapper.writeValueAsString(placeTg);
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

    public String deletePlace(String placeId) throws ShirpoException {
        try {
            final PlaceTg placeTg = placeTgRepository.findPlace(placeId);
            if (placeTg == null)
                throw new PlaceNotFoundException();
            placeTgRepository.delete(placeTg);
            return "OK";
        } catch (PlaceNotFoundException e) {
            throw e;
        } catch (MongoException e) {
            throw new MongoCrashException();
        } catch (Exception e) {
            throw new PizdecException();
        }
    }

    public String putPlace(String placeId, PutPlaceTgRequest putPlaceRequest) throws ShirpoException {
        try {
            PlaceTg updatedPlace = mapper.readValue(mapper.writeValueAsString(putPlaceRequest), PlaceTg.class);
            if (!Objects.equals(placeId, putPlaceRequest.getPlaceId()))
                throw new PlaceIdNotEqualsException();
            final PlaceTg oldPlace = placeTgRepository.findPlace(placeId);
            if (oldPlace == null)
                throw new PlaceNotFoundException();

            final PlaceTg newPlace = new PlaceTg(
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

            placeTgRepository.save(newPlace);
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
}
