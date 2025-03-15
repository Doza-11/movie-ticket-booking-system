package com.movie_ticket_booking_system.services;

import com.movie_ticket_booking_system.convertor.TicketConvertor;
import com.movie_ticket_booking_system.entities.Show;
import com.movie_ticket_booking_system.entities.ShowSeat;
import com.movie_ticket_booking_system.entities.Ticket;
import com.movie_ticket_booking_system.entities.User;
import com.movie_ticket_booking_system.exceptions.SeatsNotAvailable;
import com.movie_ticket_booking_system.exceptions.ShowDoesNotExists;
import com.movie_ticket_booking_system.exceptions.TicketIdIsInvalid;
import com.movie_ticket_booking_system.exceptions.UserDoesNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie_ticket_booking_system.repositories.ShowRepository;
import com.movie_ticket_booking_system.repositories.TicketRepository;
import com.movie_ticket_booking_system.repositories.UserRepository;
import com.movie_ticket_booking_system.requests.TicketRequest;
import com.movie_ticket_booking_system.response.TicketResponse;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public TicketResponse bookTicket(TicketRequest ticketRequest) {
        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());
        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());

        if(showOpt.isEmpty())
        {
            throw new ShowDoesNotExists();
        }

        if(userOpt.isEmpty())
        {
            throw new UserDoesNotExists();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(), ticketRequest.getRequestedSeats());

        if(!isSeatAvailable)
        {
            throw new SeatsNotAvailable();
        }
        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),	ticketRequest.getRequestedSeats());

        String seats = listToString(ticketRequest.getRequestedSeats());

        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        return TicketConvertor.returnTicket(show, ticket);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats){
        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();

            if(requestSeats.contains(seatNo) && !showSeat.getIsAvailable())
            {
                return false;
            }
        }
        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats){
        Integer totalPrice = 0;

        for(ShowSeat showSeat : showSeatList){

            if(requestSeats.contains(showSeat.getSeatNo()))
            {
                totalPrice += showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }
        return totalPrice;
    }

    private String listToString(List<String> requestSeats){
        StringBuilder sb = new StringBuilder();
        for(String seatNo : requestSeats){
            sb.append(seatNo).append(",");
        }
        return sb.toString();
    }

}


