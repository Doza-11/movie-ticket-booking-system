package com.movie_ticket_booking_system.convertor;

import com.movie_ticket_booking_system.entities.Show;
import com.movie_ticket_booking_system.entities.Ticket;
import com.movie_ticket_booking_system.response.TicketResponse;


public class TicketConvertor {
    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
