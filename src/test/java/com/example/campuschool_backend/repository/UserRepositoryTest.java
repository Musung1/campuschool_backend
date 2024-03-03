package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.user.LoginType;
import com.example.campuschool_backend.domain.user.RoleType;
import com.example.campuschool_backend.domain.user.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired UserRepository userRepository;

    @Test
    public void userCRUDTest() {
        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL, RoleType.USER);
        UserEntity saveUser = userRepository.save(user);

        //1. create, find
        UserEntity findUser = userRepository.findById(saveUser.getId()).orElseThrow(()->new RuntimeException());
        Assertions.assertThat(user).isEqualTo(findUser);
        //2. update
        user.setName("leeZZin");
        UserEntity findAndUpdateUser = userRepository.findById(saveUser.getId()).orElseThrow(()->new RuntimeException());
        Assertions.assertThat(user).isEqualTo(findAndUpdateUser);
        //3. delete
        userRepository.delete(user);
        Assertions.assertThatThrownBy(()->userRepository.findById(saveUser.getId()).orElseThrow(()->new RuntimeException()))
                .isInstanceOf(RuntimeException.class);
        //assertThrows(RuntimeException.class, (Executable) userRepository.findById(saveUser.getId()).orElseThrow(()->new RuntimeException()));
    }

}