package services;

import convertor.UserConvertor;
import entities.User;
import exceptions.UserAlreadyExists;
import exceptions.UserDoesNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import requests.UserRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addNewUser(UserRequest userRequest) {
        User userOpt = userRepository.findByEmailId(userRequest.getEmailId());
        if (userOpt.getEmailId() != null) {
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
