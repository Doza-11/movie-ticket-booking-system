package com.movie_ticket_booking_system.exceptions;

public class TheaterIsNotExists extends RuntimeException {
    public TheaterIsNotExists() {
        super("The theater is not exists");
    }
}
