package com.example.parsasequipmentnewsapp.controller;

import com.example.parsasequipmentnewsapp.dto.user.UserDto;
import com.example.parsasequipmentnewsapp.modle.Role;
import com.example.parsasequipmentnewsapp.modle.User;
import com.example.parsasequipmentnewsapp.service.user.CustomUserDetailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService userDetailService;
    private final AuthenticationManager authenticationManager;

    public UserController(PasswordEncoder passwordEncoder
            , CustomUserDetailService userDetailService
            , AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailService = userDetailService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestParam UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setRole(Role.USER);
        userDetailService.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username
            , @RequestParam String password
            , HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authenticate = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticate);

            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository
                    .SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> all = userDetailService.findAll();
        return ResponseEntity.ok(all);
    }
}
