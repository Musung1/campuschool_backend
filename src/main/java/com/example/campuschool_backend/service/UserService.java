package com.example.campuschool_backend.service;

import com.example.campuschool_backend.dto.auth.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;

public interface UserService {
    public UserDTO signUp(SignUpForm signUpForm);
    public UserDTO logIn(String username);

}
