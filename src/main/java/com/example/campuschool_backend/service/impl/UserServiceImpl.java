package com.example.campuschool_backend.service.impl;

import com.example.campuschool_backend.domain.user.LoginType;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.auth.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.repository.UserRepository;
import com.example.campuschool_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
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

    @Override
    public UserDTO logIn(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException());
        return UserDTO.from(userEntity);
    }
}
