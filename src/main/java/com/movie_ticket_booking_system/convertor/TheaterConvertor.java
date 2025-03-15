package com.movie_ticket_booking_system.convertor;

import com.movie_ticket_booking_system.entities.Theater;
import com.movie_ticket_booking_system.requests.TheaterRequest;

public class TheaterConvertor {
    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getTheaterName())
                .address(theaterRequest.getTheaterAddress())
                .build();
        return theater;
    }
}


