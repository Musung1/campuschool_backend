package com.example.campuschool_backend.service;

import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.lecture.LectureCardDTO;

import java.util.List;

public interface LectureService {
    Long createLecture(CreateLectureForm lectureForm);
    List<LectureCardDTO> popularLectures();
}
