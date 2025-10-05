package com.example.parsasequipmentnewsapp.dto.user;

import com.example.parsasequipmentnewsapp.modle.Role;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;

    public UserDto(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    @NotBlank(message = "user.dto.username.blank")
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "user.dto.password.blank")
    public String getPassword() {
        return password;
    }

    @NotBlank(message = "user.dto.email.blank")
    public String getEmail() {
        return email;
    }

    @NotBlank(message = "user.dto.full.name.blank")
    public String getFullName() {
        return fullName;
    }
}
