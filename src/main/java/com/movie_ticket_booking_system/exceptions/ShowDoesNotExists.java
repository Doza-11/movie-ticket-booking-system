package com.movie_ticket_booking_system.exceptions;

public class ShowDoesNotExists extends RuntimeException {
    public ShowDoesNotExists() {
        super("Show doesn't exists");
    }
}
