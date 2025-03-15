package com.movie_ticket_booking_system.exceptions;

public class MovieDoesNotExists extends RuntimeException {

    public MovieDoesNotExists() {
        super("Movie does not Exists");
    }
}
