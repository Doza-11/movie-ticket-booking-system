package com.movie_ticket_booking_system.controllers;

import com.movie_ticket_booking_system.convertor.UserConvertor;
import com.movie_ticket_booking_system.entities.User;
import com.movie_ticket_booking_system.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.movie_ticket_booking_system.requests.UserRequest;
import com.movie_ticket_booking_system.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addNew")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest) {
        try {
            String result = userService.addNewUser(userRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        try{
            UserConvertor userConvertor = new UserConvertor();
            List<UserResponse> users = userService.getAllUsers()
                    .stream()
                    .map(UserConvertor::userToUserResponse)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }
}