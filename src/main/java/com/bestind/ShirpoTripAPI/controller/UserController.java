package com.bestind.ShirpoTripAPI.controller;

import com.bestind.ShirpoTripAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok().body("All ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("not ok");
        }
    }

    //Place to JSON converter
    public PlaceToJson(Place){
        let jSonData = {
                title = Place.title,
                place_id = Place.place_id,
                description = Place.descrition,
                feedback = Place.feedback,
                visitor_age = Place.visitor_age,
                url = Place.url,
                avarage_price = Place.avarage_price,
                location = Place.location,
                relax_type = Place.relaxType,
                tags = Place.tags,
                contact_info = Place.contact_info,
                schedule = Place.schedule
        };
        return JSON.stringfy(jSonData);
    }

    //JSON to Place converter
    public JsonToPlace(jSonData){
        let place = {
                title = jSonData.title,
                place_id = jSonData.place_id,
                description = jSonData.descrition,
                feedback = jSonData.feedback,
                visitor_age = jSonData.visitor_age,
                url = jSonData.url,
                avarage_price = jSonData.avarage_price,
                location = jSonData.location,
                relax_type = jSonData.relaxType,
                tags = jSonData.tags,
                contact_info = jSonData.contact_info,
                schedule = jSonData.schedule
        };
        return Place;
    }
}
