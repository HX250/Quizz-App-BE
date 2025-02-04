package main.java.com.example.devOpsDemo.service;

import com.example.devOpsDemo.dto.request.RegisterRequest;
import main.java.com.example.devOpsDemo.dto.request.LoginRequest;
import main.java.com.example.devOpsDemo.entity.User;
import main.java.com.example.devOpsDemo.exception.CustomException;
import main.java.com.example.devOpsDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(RegisterRequest request) {
       if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("The email address is already taken.");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new CustomException("This username is already taken.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }

    public String authenticate(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("User not found"));

        if (!Objects.equals(request.getPassword(), user.getPassword())) {
            throw new CustomException("Invalid credentials");
        }

        return generateToken();
    }


    public String generateToken() {
        Random rnd = new Random();
        int token = 100000 + rnd.nextInt(900000);
        System.out.println(token);
        return String.valueOf(token);
    }
}
