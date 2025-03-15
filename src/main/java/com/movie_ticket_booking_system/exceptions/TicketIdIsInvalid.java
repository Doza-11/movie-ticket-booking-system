package com.movie_ticket_booking_system.exceptions;

public class TicketIdIsInvalid extends RuntimeException {
    public TicketIdIsInvalid() {
        super("Ticket Id is invalid");
    }
}
