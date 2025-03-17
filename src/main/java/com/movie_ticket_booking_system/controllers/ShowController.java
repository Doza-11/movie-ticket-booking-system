package com.movie_ticket_booking_system.controllers;

import com.movie_ticket_booking_system.convertor.UserConvertor;
import com.movie_ticket_booking_system.response.ShowResponse;
import com.movie_ticket_booking_system.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.movie_ticket_booking_system.requests.ShowRequest;
import com.movie_ticket_booking_system.requests.ShowSeatRequest;
import com.movie_ticket_booking_system.services.ShowService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addShow(@RequestBody ShowRequest showRequest) {
        try {
            String result = showService.addShow(showRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateSeats(@RequestBody ShowSeatRequest showSeatRequest) {
        try{
            String result = showService.associateSeat(showSeatRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allshow/{theaterName}")
    public ResponseEntity<List<ShowResponse>> getShowsByTheaterName(@PathVariable String theaterName) {
        try {
            List<ShowResponse> shows = showService.getShowsByTheaterName(theaterName);
            return new ResponseEntity<>(shows, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }
}
