package com.example.parsasequipmentnewsapp.dto.user;

import com.example.parsasequipmentnewsapp.modle.Role;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    private final Role role;

    public UserDto(String username, String password, String email, String fullName, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
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

    @NotBlank(message = "user.dto.role.blank")
    public Role getRole() {
        return role;
    }
}
