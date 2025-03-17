package com.movie_ticket_booking_system.repositories;

import com.movie_ticket_booking_system.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);

    Optional<Theater> findByName(String theaterName);
}