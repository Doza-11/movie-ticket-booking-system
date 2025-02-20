package services;

import convertor.MovieConvertor;
import entities.Movie;
import exceptions.MovieAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MovieRepository;
import requests.MovieRequest;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
            throw new MovieAlreadyExist();
        }

        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }

}
