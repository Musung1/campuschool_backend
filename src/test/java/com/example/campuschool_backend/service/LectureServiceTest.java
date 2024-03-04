<<<<<<< HEAD
//package com.example.campuschool_backend.service;
//
//import com.example.campuschool_backend.domain.lecture.AvaliableTime;
//import com.example.campuschool_backend.domain.lecture.CurriculumEntity;
//import com.example.campuschool_backend.domain.lecture.Lecture;
//import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
//import com.example.campuschool_backend.domain.lecture.enums.Days;
//import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
//import com.example.campuschool_backend.domain.user.LoginType;
//import com.example.campuschool_backend.domain.user.RoleType;
//import com.example.campuschool_backend.domain.user.UserEntity;
//import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
//import com.example.campuschool_backend.dto.auth.SignUpForm;
//import com.example.campuschool_backend.dto.UserDTO;
//import com.example.campuschool_backend.repository.LectureRepository;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import jakarta.persistence.EntityManager;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//
//@SpringBootTest
//class LectureServiceTest {
//    @Autowired private LectureService lectureService;
//    @Autowired private LectureRepository lectureRepository;
//    @Autowired private UserService userService;
//    @Autowired private EntityManager entityManager;
//
//    @BeforeEach
//    public void signUp() {
//        SignUpForm signUpForm = new SignUpForm();
//        signUpForm.setUsername("123123");
//        signUpForm.setPassword("123123");
//        signUpForm.setName("musung");
//
//        UserDTO userDTO = userService.signUp(signUpForm);
//    }
//
//    @Test
//    public void createLectureTest() {
//        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL, RoleType.USER);
//
//        AvaliableTime avaliableTime = AvaliableTime.of(Days.월,"0900");
//        AvaliableTime avaliableTime1 = AvaliableTime.of(Days.금,"9030");
=======
package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.lecture.AvaliableTime;
import com.example.campuschool_backend.domain.lecture.CurriculumEntity;
import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Days;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.auth.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LectureServiceTest {
    @Autowired private LectureService lectureService;
    @Autowired private LectureRepository lectureRepository;
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;
    @Autowired private EntityManager entityManager;

    @BeforeEach
    public void signUp() {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setUsername("123123");
        signUpForm.setPassword("123123");
        signUpForm.setName("musung");

        UserDTO userDTO = userService.signUp(signUpForm);
    }

//    @Test
//    public void createLectureTest() {
//        AvaliableTime avaliableTime = AvaliableTime.of(Days.MON,"0900");
//        AvaliableTime avaliableTime1 = AvaliableTime.of(Days.FRI,"9030");
>>>>>>> main
//        avaliableTime.setRegisterBy(1L);
//        avaliableTime1.setRegisterBy(1L);
//        CurriculumEntity curriculumEntity = CurriculumEntity.of(1,"title1","description1");
//        CurriculumEntity curriculumEntity1 = CurriculumEntity.of(2,"title2","description");
//        List<CurriculumEntity> curriculumEntityList = Arrays.asList(curriculumEntity, curriculumEntity1);
//        List<AvaliableTime> avaliableTimeList = Arrays.asList(avaliableTime,avaliableTime1);
//        CreateLectureForm createLectureForm = CreateLectureForm.builder()
//                .title("title1")
//                .categoryType(CategoryType.CODING)
//                .difficulty(Difficulty.LOW)
//                .avaliableTimeList(avaliableTimeList)
//                .curriculumList(curriculumEntityList)
//                .build();
//        Long lectureId = lectureService.createLecture(createLectureForm);
//        Lecture findLecture = lectureRepository.findById(lectureId).orElseThrow(()->new RuntimeException());
//        Assertions.assertThat(findLecture).isNotNull();
//    }
<<<<<<< HEAD
//    @Test
//    public void test() {
//        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
//        JPAQueryFactory query = new JPAQueryFactory(entityManager);
//    }
//
//}
=======
    @Test
    public void test() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
    }

}
>>>>>>> main
