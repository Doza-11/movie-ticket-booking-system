package com.movie_ticket_booking_system.convertor;

import com.movie_ticket_booking_system.entities.User;
import com.movie_ticket_booking_system.enums.Gender;
import com.movie_ticket_booking_system.requests.UserRequest;
import com.movie_ticket_booking_system.response.UserResponse;

public class UserConvertor {
    public static User userDtoToUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .emailId(userRequest.getEmailId())
                .roles(userRequest.getRoles())
                .build();

        return user;
    }

    public static UserResponse userToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getAddress(),
                user.getGender(),
                user.getMobileNo(),
                user.getEmailId(),
                user.getRoles());
    }
}