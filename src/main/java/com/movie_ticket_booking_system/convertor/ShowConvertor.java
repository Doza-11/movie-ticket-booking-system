package com.movie_ticket_booking_system.convertor;


import com.movie_ticket_booking_system.entities.Movie;
import com.movie_ticket_booking_system.entities.Show;
import com.movie_ticket_booking_system.requests.ShowRequest;
import com.movie_ticket_booking_system.response.ShowResponse;

import java.sql.Date;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date((Date) showRequest.getShowDate())
                .build();

        return show;
    }

    public static ShowResponse showToShowResponse(Show show) {
        ShowResponse showResponse = ShowResponse.builder()
                .time(show.getTime())
                .date(show.getDate())
                .movieName(show.getMovie().getMovieName())
                .build();

        return showResponse;
    }
}