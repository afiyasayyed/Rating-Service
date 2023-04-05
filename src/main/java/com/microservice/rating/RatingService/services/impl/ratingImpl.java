package com.microservice.rating.RatingService.services.impl;

import com.microservice.rating.RatingService.entities.Rating;
import com.microservice.rating.RatingService.repositories.RatingRepo;
import com.microservice.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ratingImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating create(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingofHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
