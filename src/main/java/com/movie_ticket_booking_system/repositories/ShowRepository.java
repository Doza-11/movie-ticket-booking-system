package com.movie_ticket_booking_system.repositories;

import com.movie_ticket_booking_system.entities.Movie;
import com.movie_ticket_booking_system.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movie_ticket_booking_system.entities.Show;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    List<Show> findByTheater(Theater theater);

    List<Show> findByMovie(Movie movie);
}
