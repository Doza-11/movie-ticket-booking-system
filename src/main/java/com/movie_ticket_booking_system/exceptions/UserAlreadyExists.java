package com.movie_ticket_booking_system.exceptions;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists() {
        super("User is already exists");
    }
}
