//package com.example.campuschool_backend.repository;
//
//import com.example.campuschool_backend.domain.lecture.Lecture;
//import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
//import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
//import com.example.campuschool_backend.domain.user.LoginType;
//import com.example.campuschool_backend.domain.user.UserEntity;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class LectureRepositoryTest {
//    @Autowired LectureRepository  lectureRepository;
//    @Autowired UserRepository userRepository;
//    @Test
//    public void lectureCRUDTest() {
//        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL);
//        UserEntity saveUser = userRepository.save(user);
//        Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
//        //1. save, find
//        Lecture saveLecture = lectureRepository.save(lecture);
//        Lecture findLecture = lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException());
//        Assertions.assertThat(lecture).isEqualTo(findLecture);
//        Assertions.assertThat(user).isEqualTo(findLecture.getTeacher());
//        //2. update;
//        findLecture.setTitle("lecture2");
//        Lecture findAndUpdateLecture = lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException());
//        Assertions.assertThat(lecture).isEqualTo(findAndUpdateLecture);
//        //3. delete
//        lectureRepository.delete(lecture);
//        Assertions.assertThatThrownBy(()->lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException()))
//                .isInstanceOf(RuntimeException.class);
//    }
//
//    @Test void popularLectureTest() {
//        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL);
//        UserEntity saveUser = userRepository.save(user);
//        List<Lecture> lectures = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
//            lecture.setViews(i);
//            lectures.add(lecture);
//            lectureRepository.save(lecture);
//        }
//        List<Lecture> popularLectures = lectureRepository.findPopularLectures();
//        Assertions.assertThat(popularLectures).isNotNull();
//    }
//
//    @Test void newLecturesTest() {
//        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL);
//        UserEntity saveUser = userRepository.save(user);
//        List<Lecture> lectures = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
//            lecture.setViews(i);
//            lectures.add(lecture);
//            lectureRepository.save(lecture);
//        }
//        List<Lecture> newLectures = lectureRepository.findNewLectures();
//        Assertions.assertThat(newLectures).isNotNull();
//    }
//
//}