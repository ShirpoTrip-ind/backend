package com.bestind.ShirpoTripAPI.extension;

import com.bestind.ShirpoTripAPI.entity.place.PutPlaceRequest;
import com.bestind.ShirpoTripAPI.model.Place;
import org.bson.types.ObjectId;

public class ExtensionToPlace {
    public static Place PutRequestToPlace(ObjectId id, String placeId, PutPlaceRequest putPlaceRequest) {

        return new Place(
                id,
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
    }
}
