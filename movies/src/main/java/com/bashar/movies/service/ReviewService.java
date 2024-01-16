package com.bashar.movies.service;

import com.bashar.movies.entity.Movie;
import com.bashar.movies.entity.Review;
import com.bashar.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody , String imdbId ){

        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdb").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first(); // to make sure that we are getting a single movie and update that

        return review;
    }
}
