package com.movie_ticket_booking_system.requests;

import lombok.Data;

@Data
public class AuthRequest {
    private String emailId;
    private String password;
}