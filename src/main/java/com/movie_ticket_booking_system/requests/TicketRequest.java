package com.movie_ticket_booking_system.requests;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequest {
    private Integer showId;
    private Integer userId;
    private List<String>  requestedSeats;
}
