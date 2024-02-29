package com.example.campuschool_backend.service;

import com.example.campuschool_backend.dto.CreateLectureForm;

public interface LectureService {
    Long createLecture(CreateLectureForm lectureForm);
}
