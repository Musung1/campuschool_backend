package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.user.LoginType;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserDTO signUp(SignUpForm signUpForm) {
        UserEntity user = UserEntity.of(
                signUpForm.getUsername(),
                passwordEncoder.encode(signUpForm.getPassword()),
                signUpForm.getName(),
                LoginType.EMAIL);
        UserEntity savedUser = userRepository.save(user);
        UserDTO userDTO = UserDTO.from(savedUser);
        return userDTO;
    }
}
