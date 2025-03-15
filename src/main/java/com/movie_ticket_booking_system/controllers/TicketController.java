package com.movie_ticket_booking_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.movie_ticket_booking_system.requests.TicketRequest;
import com.movie_ticket_booking_system.response.TicketResponse;
import com.movie_ticket_booking_system.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/booking")
    private ResponseEntity<Object> bookTicket(@RequestBody TicketRequest ticketRequest){
     try{
         TicketResponse result = ticketService.bookTicket(ticketRequest);
         return new ResponseEntity<>(result, HttpStatus.OK);
     }catch (Exception e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
     }
    }
}
