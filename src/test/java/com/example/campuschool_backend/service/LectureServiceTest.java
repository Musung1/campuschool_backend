package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.lecture.AvaliableTime;
import com.example.campuschool_backend.domain.lecture.CurriculumEntity;
import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Days;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import com.example.campuschool_backend.dto.CreateLectureForm;
import com.example.campuschool_backend.dto.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.repository.LectureRepository;
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

    @BeforeEach
    public void signUp() {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setUsername("123123");
        signUpForm.setPassword("123123");
        signUpForm.setName("musung");

        UserDTO userDTO = userService.signUp(signUpForm);
    }

    @Test
    public void createLectureTest() {
        AvaliableTime avaliableTime = AvaliableTime.of(Days.MON,"0900");
        AvaliableTime avaliableTime1 = AvaliableTime.of(Days.FRI,"9030");
        avaliableTime.setRegisterBy(1L);
        avaliableTime1.setRegisterBy(1L);
        CurriculumEntity curriculumEntity = CurriculumEntity.of(1,"title1","description1");
        CurriculumEntity curriculumEntity1 = CurriculumEntity.of(2,"title2","description");
        List<CurriculumEntity> curriculumEntityList = Arrays.asList(curriculumEntity, curriculumEntity1);
        List<AvaliableTime> avaliableTimeList = Arrays.asList(avaliableTime,avaliableTime1);
        CreateLectureForm createLectureForm = CreateLectureForm.builder()
                .title("title1")
                .categoryType(CategoryType.CODING)
                .difficulty(Difficulty.LOW)
                .avaliableTimeList(avaliableTimeList)
                .curriculumEntityList(curriculumEntityList)
                .build();
        Long lectureId = lectureService.createLecture(createLectureForm);
        Lecture findLecture = lectureRepository.findById(lectureId).orElseThrow(()->new RuntimeException());
        Assertions.assertThat(findLecture).isNotNull();
    }

}