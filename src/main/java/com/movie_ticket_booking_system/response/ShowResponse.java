package com.movie_ticket_booking_system.response;

import com.movie_ticket_booking_system.entities.Movie;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowResponse {
    private Time time;
    private Date date;
    private String movieName;
    private String theaterName;
}
