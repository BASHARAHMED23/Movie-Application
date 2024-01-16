package com.bashar.movies.repository;

import com.bashar.movies.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review , ObjectId> {
}
