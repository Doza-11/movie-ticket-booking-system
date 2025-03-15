package com.movie_ticket_booking_system.exceptions;

public class SeatsNotAvailable extends RuntimeException {
    public SeatsNotAvailable() {
        super("Seats not available");
    }
}
