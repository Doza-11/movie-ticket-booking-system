package com.movie_ticket_booking_system.repositories;

import com.movie_ticket_booking_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String email);
}
