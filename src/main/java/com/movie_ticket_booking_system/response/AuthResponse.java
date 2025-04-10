package com.movie_ticket_booking_system.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String emailId;
    private String roles;
}
