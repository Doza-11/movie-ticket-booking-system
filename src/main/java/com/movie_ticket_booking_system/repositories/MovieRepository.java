package com.movie_ticket_booking_system.repositories;

import com.movie_ticket_booking_system.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByMovieName(String movieName);
    Optional<Movie> findByMovieName(String name);
}
