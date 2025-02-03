package com.example.devOpsDemo.controller;


import com.example.devOpsDemo.dto.UserDto;
import com.example.devOpsDemo.dto.request.LoginRequest;
import com.example.devOpsDemo.dto.request.RegisterRequest;
import com.example.devOpsDemo.dto.response.LoginResponse;
import com.example.devOpsDemo.entity.User;
import com.example.devOpsDemo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        UserDto registeredUser = authService.signup(request);

        return ResponseEntity.ok("hello");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
       // User authenticatedUser = authService.authenticate(request);

        LoginResponse loginResponse = new LoginResponse("asdasd");

        return ResponseEntity.ok(loginResponse);
    }
}
