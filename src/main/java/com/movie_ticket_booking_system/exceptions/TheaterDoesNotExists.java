package com.movie_ticket_booking_system.exceptions;

public class TheaterDoesNotExists extends RuntimeException {

    public TheaterDoesNotExists() {
        super("Theater does not Exists");
    }
}
