<<<<<<< HEAD
package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import com.example.campuschool_backend.domain.user.LoginType;
import com.example.campuschool_backend.domain.user.RoleType;
import com.example.campuschool_backend.domain.user.UserEntity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LectureRepositoryTest {
    @Autowired LectureRepository  lectureRepository;
    @Autowired UserRepository userRepository;
    @Test
    public void lectureCRUDTest() {
        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL,RoleType.USER);
        UserEntity saveUser = userRepository.save(user);
        Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
        //1. save, find
        Lecture saveLecture = lectureRepository.save(lecture);
        Lecture findLecture = lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException());
        Assertions.assertThat(lecture).isEqualTo(findLecture);
        Assertions.assertThat(user).isEqualTo(findLecture.getTeacher());
        //2. update;
        findLecture.setTitle("lecture2");
        Lecture findAndUpdateLecture = lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException());
        Assertions.assertThat(lecture).isEqualTo(findAndUpdateLecture);
        //3. delete
        lectureRepository.delete(lecture);
        Assertions.assertThatThrownBy(()->lectureRepository.findById(saveLecture.getId()).orElseThrow(()->new RuntimeException()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test void popularLectureTest() {
        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL,RoleType.USER);
        UserEntity saveUser = userRepository.save(user);
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
            lecture.setViews(i);
            lectures.add(lecture);
            lectureRepository.save(lecture);
        }
        List<Lecture> popularLectures = lectureRepository.findPopularLectures();
        Assertions.assertThat(popularLectures).isNotNull();
    }

    @Test void newLecturesTest() {
        UserEntity user = UserEntity.of("123123","123123","musung", LoginType.EMAIL,RoleType.USER);
        UserEntity saveUser = userRepository.save(user);
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lecture lecture = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
            lecture.setViews(i);
            lectures.add(lecture);
            lectureRepository.save(lecture);
        }
        List<Lecture> newLectures = lectureRepository.findRecentLectures();
        Assertions.assertThat(newLectures).isNotNull();
    }
    @Test void getMyOpenLectureTest() {
        UserEntity user = UserEntity.of("musung","musung","musung",LoginType.EMAIL, RoleType.USER);
        UserEntity saveUser = userRepository.save(user);
        Lecture lecture1 = Lecture.of("lecture1", CategoryType.CODING, Difficulty.LOW,user);
        Lecture lecture2 = Lecture.of("lecture2", CategoryType.CODING, Difficulty.LOW,user);
        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        List<Lecture> myOpenLectures = lectureRepository.findMyOpenLectures(saveUser.getId());

        Assertions.assertThat(lecture1).isEqualTo(myOpenLectures.get(0));
        Assertions.assertThat(lecture2).isEqualTo(myOpenLectures.get(1));
    }

}
=======
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
>>>>>>> main
