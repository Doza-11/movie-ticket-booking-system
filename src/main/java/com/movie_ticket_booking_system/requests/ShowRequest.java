package com.movie_ticket_booking_system.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.sql.Date;

@Data
public class ShowRequest {

    private Time showStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
