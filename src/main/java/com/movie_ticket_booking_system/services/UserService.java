package com.movie_ticket_booking_system.services;

import com.movie_ticket_booking_system.convertor.UserConvertor;
import com.movie_ticket_booking_system.entities.User;
import com.movie_ticket_booking_system.exceptions.UserAlreadyExists;
import com.movie_ticket_booking_system.exceptions.UserDoesNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie_ticket_booking_system.repositories.MovieRepository;
import com.movie_ticket_booking_system.repositories.UserRepository;
import com.movie_ticket_booking_system.requests.UserRequest;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addNewUser(UserRequest userRequest) {
        User userOpt = userRepository.findByEmailId(userRequest.getEmailId());
        if (userOpt != null) {
            throw new UserAlreadyExists();
        }

        User user = UserConvertor.userDtoToUser(userRequest);
        userRepository.save(user);

        return "User created successfully";
    }

    public List<User> getAllUsers() {

        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new UserDoesNotExists();
        }
        return userList;
    }
}