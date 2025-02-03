package com.example.devOpsDemo.service;

import com.example.devOpsDemo.dto.UserDto;
import com.example.devOpsDemo.dto.request.RegisterRequest;
import com.example.devOpsDemo.entity.User;
import com.example.devOpsDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto signup(RegisterRequest request) {
       // if (userRepository.findByEmail(request.getEmail()).isPresent()) {
        //    throw new EmailAlreadyTakenException("The email address is already taken.");
       // }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return new UserDto(user.getEmail(), user.getUsername());
    }
}
