package com.movie_ticket_booking_system.requests;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String theaterAddress;
    private Integer noOfSeatsInRow;
    private Integer noOfPremiumSeats;
    private Integer noOfClassicSeats;
}
