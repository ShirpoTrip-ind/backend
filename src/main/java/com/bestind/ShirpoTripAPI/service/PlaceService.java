package com.bestind.ShirpoTripAPI.service;

import com.bestind.ShirpoTripAPI.entity.DeletePlaceRequest;
import com.bestind.ShirpoTripAPI.repository.PlaceRepository;
import com.bestind.ShirpoTripAPI.exception.place.PlaceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    public  PlaceService(PlaceRepository placeRepo) {
        this.placeRepo = placeRepo;
    }


    //public void deletePlace(DeletePlaceRequest deletePlaceRequest) throws PlaceException {
    //    try {
    //        String placeId = deletePlaceRequest.getPlace_id();
    //
    //        if (placeId == null || placeId.isEmpty()) {
    //            //throw new PlaceException(/*"Invalid place id provided."*/);
    //            throw new PlaceBadRequestException();
    //        }
    //
    //        Place place = mongoTemplate.findById(placeId, Place.class);
    //
    //        if (place == null) {
    //            //throw new PlaceException(/*"Place with id " + placeId + " not found"*/);
    //            throw new PlaceNotFoundException();
    //        }
    //        mongoTemplate.remove(place);
    //
    //        //return "Place with id " + placeId + " has been deleted successfully";
    //
    //    } catch (IllegalArgumentException e) {
    //
    //        //throw new PlaceException(/*"Error: Illegal argument - " + e.getMessage()*/);
    //
    //        throw new PlaceBadRequestException();
    //    } catch (DataAccessException e) {
    //
    //        //throw new PlaceException(/*"Error accessing data - " + e.getMessage()*/);
    //
    //        throw new ServerAccessException();
    //    } catch (Exception e) {
    //        throw new ServerAccessException();
    //    }
    //
    //}


    public String deletePlace(DeletePlaceRequest deletePlaceRequest) throws PlaceException {
        try {
            if (placeRepo.findPlace(deletePlaceRequest.getPlace_id()).isEmpty())
                throw new PlaceNotFoundException();


            mongoTemplate.remove(placeRepo.findPlace(deletePlaceRequest.getPlace_id()));
            return ("Ok");






        } catch (Exception e) {
            throw new PlaceBadRequestException();
        }
    }
}
