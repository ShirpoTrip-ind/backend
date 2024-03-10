package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.exception.place.PlaceBadRequestException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceException;
import com.bestind.ShirpoTripAPI.exception.place.PlaceNotFoundException;
import com.bestind.ShirpoTripAPI.model.Place;
import com.bestind.ShirpoTripAPI.repository.PlaceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepo;
    private final ObjectMapper mapper;

    @Autowired
    MongoTemplate mongoTemplate;


    @Autowired
    public PlaceService(PlaceRepository placeRepo, ObjectMapper mapper) {
        this.placeRepo = placeRepo;
        this.mapper = mapper;
    }

    public String putPlace(PutPlaceRequest putPlaceRequest) throws PlaceException {
        try {
            Place updatedPlace = new Place(putPlaceRequest.getTitle(), putPlaceRequest.getDescription(), putPlaceRequest.getFeedback(), putPlaceRequest.getVisitor_age(), putPlaceRequest.getUrl(), putPlaceRequest.getAverage_price(),
                    putPlaceRequest.getLocation(), putPlaceRequest.getRelaxType(), putPlaceRequest.getTags(), putPlaceRequest.getContact_info(), putPlaceRequest.getSchedule());

            if (placeRepo.findPlace(putPlaceRequest.getPlace_id()).isEmpty())
                throw new PlaceNotFoundException();

            return mapper.writeValueAsString(updatedPlace);

        } catch (JsonProcessingException e) {
            throw new PlaceBadRequestException();
        }
    }

}