package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.lecture.Lecture;

import java.util.List;

public interface CustomLectureRepository {
    List<Lecture> findPopularLectures();
}
