package com.movie_ticket_booking_system.exceptions;

public class TheaterAlreadyExist extends RuntimeException {
    public TheaterAlreadyExist() {
        super("Theater already exist");
    }
}
