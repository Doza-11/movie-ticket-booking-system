package services;

import convertor.UserConvertor;
import entities.User;
import exceptions.UserAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import requests.UserRequest;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserRequest userRequest) {
        Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());
        if (users.isPresent()) {
            throw new UserAlreadyExists();
        }

        User user = UserConvertor.userDtoToUser(userRequest, passwordEncoder.encode("1234"));
        userRepository.save(user);

        return "User created successfully";
    }
}
