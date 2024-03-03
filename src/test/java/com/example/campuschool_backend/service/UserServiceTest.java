package com.example.campuschool_backend.service;

import com.example.campuschool_backend.dto.auth.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired UserService userService;
    @Test
    public void signUpTest() {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setUsername("123123");
        signUpForm.setPassword("123123");
        signUpForm.setName("musung");

        UserDTO userDTO = userService.signUp(signUpForm);
        Assertions.assertThat(userDTO).isNotNull();

    }

}