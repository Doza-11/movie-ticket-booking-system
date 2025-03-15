package com.movie_ticket_booking_system.exceptions;

public class UserDoesNotExists extends RuntimeException {
    public UserDoesNotExists() {
        super("User does not exist");
    }
}
