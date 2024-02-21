package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.lecture.Lecture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class LectureRepositoryTest {
    @Autowired LectureRepository lectureRepository;
    @Test
    public void lectureCRUDTest() {
        //Lecture lecture = Lecture
    }

}