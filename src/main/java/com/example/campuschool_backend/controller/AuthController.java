package com.example.campuschool_backend.controller;

import com.example.campuschool_backend.dto.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "Authorization")
@RestController
@RequestMapping("/api")
public class AuthController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpForm signUpForm) {
        UserDTO userDTO = userService.signUp(signUpForm);
        return ResponseEntity.ok(userDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> logIn(HttpServletRequest request, HttpServletResponse response) {
        String username = (String)request.getAttribute("username");
        UserDTO userDTO = userService.logIn(username);
        System.out.println(response.getHeader("Authorization"));
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("logout")
    public ResponseEntity<String> logOut() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("logout");
    }
    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }
}
