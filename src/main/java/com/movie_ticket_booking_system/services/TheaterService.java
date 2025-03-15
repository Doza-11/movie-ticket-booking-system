package com.movie_ticket_booking_system.services;

import com.movie_ticket_booking_system.convertor.TheaterConvertor;
import com.movie_ticket_booking_system.entities.Theater;
import com.movie_ticket_booking_system.entities.TheaterSeat;
import com.movie_ticket_booking_system.enums.SeatType;
import com.movie_ticket_booking_system.exceptions.TheaterAlreadyExist;
import com.movie_ticket_booking_system.exceptions.TheaterIsNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import com.movie_ticket_booking_system.repositories.TheaterRepository;
import com.movie_ticket_booking_system.requests.TheaterRequest;
import com.movie_ticket_booking_system.requests.TheaterSeatRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterRequest theaterRequest) throws TheaterAlreadyExist {
        if (theaterRepository.findByAddress(theaterRequest.getTheaterAddress()) != null) {
            throw new TheaterAlreadyExist();
        }

        Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);
        theaterRepository.save(theater);
        return "The theater has been added successfully";
    }

    public String addTheaterSeats(TheaterSeatRequest theaterSeatRequest) throws TheaterIsNotExists {
        if(theaterRepository.findByAddress(theaterSeatRequest.getTheaterAddress()) == null) {
            throw new TheaterIsNotExists();
        }

        Integer noOfSeatsInRow = theaterSeatRequest.getNoOfSeatsInRow();
        Integer noOfPremiumSeats = theaterSeatRequest.getNoOfPremiumSeats();
        Integer noOfClassicSeats = theaterSeatRequest.getNoOfClassicSeats();
        String address = theaterSeatRequest.getTheaterAddress();

        Theater theater = theaterRepository.findByAddress(address);

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for (int i = 0; i <=noOfClassicSeats; i++)
        {
            String seatNo = Integer.toString(counter) + ch;
            ch++;
            fill++;

            if(fill == noOfSeatsInRow)
            {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat  = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeat.setTheater(theater);
            theaterSeatList.add(theaterSeat);
        }

        for (int i = 0; i <=noOfPremiumSeats; i++)
        {
            String seatNo = Integer.toString(counter) + ch;
            ch++;
            fill++;

            if(fill == noOfSeatsInRow)
            {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat  = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setTheater(theater);
            theaterSeatList.add(theaterSeat);
        }
        theaterRepository.save(theater);
        return "Theater Seat has been added successfully";
    }
}
