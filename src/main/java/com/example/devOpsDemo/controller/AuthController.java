package main.java.com.example.devOpsDemo.controller;

import com.example.devOpsDemo.dto.request.RegisterRequest;
import main.java.com.example.devOpsDemo.dto.UserDto;
import main.java.com.example.devOpsDemo.dto.request.LoginRequest;
import main.java.com.example.devOpsDemo.dto.response.LoginResponse;
import main.java.com.example.devOpsDemo.entity.User;
import main.java.com.example.devOpsDemo.service.AuthService;
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

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.signup(request);
        return ResponseEntity.ok("{}");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request);
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok(loginResponse);
    }
}
