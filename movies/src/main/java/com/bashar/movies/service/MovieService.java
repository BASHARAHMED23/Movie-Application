package com.bashar.movies.service;

import com.bashar.movies.entity.Movie;
import com.bashar.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> findAllMovies(){

        return movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(String imdbId){
        // optional means that it may return null in case it doesn't find movie with the inserted id
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
