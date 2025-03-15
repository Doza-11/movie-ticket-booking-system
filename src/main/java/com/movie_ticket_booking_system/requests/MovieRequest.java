package com.movie_ticket_booking_system.requests;

import com.movie_ticket_booking_system.enums.Genre;
import com.movie_ticket_booking_system.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Genre genre;
    private Double rating;
    private Date releaseDate;
    private Language language;
}
