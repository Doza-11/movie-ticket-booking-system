package com.movie_ticket_booking_system.services;

import com.movie_ticket_booking_system.convertor.MovieConvertor;
import com.movie_ticket_booking_system.entities.Movie;
import com.movie_ticket_booking_system.exceptions.MovieAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie_ticket_booking_system.repositories.MovieRepository;
import com.movie_ticket_booking_system.requests.MovieRequest;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findMovieByMovieName(movieRequest.getMovieName());

        if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
            throw new MovieAlreadyExist();
        }

        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }

}
