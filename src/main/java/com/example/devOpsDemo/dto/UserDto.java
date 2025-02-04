package main.java.com.example.devOpsDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserDto {
    private String email;
    private String username;

    public UserDto(String email, String username) {
        this.email = email;
        this.username = username;
    }
}