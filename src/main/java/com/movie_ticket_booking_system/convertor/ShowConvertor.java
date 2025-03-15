package com.movie_ticket_booking_system.convertor;


import com.movie_ticket_booking_system.entities.Show;
import com.movie_ticket_booking_system.requests.ShowRequest;

import java.sql.Date;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date((Date) showRequest.getShowDate())
                .build();

        return show;
    }
}