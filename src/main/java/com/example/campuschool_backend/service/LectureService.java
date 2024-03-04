package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.lecture.LectureCardDTO;
import com.example.campuschool_backend.dto.lecture.LectureDetailDTO;
import com.example.campuschool_backend.dto.lecture.LectureSearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LectureService {
    Long createLecture(UserEntity userEntity, CreateLectureForm lectureForm);
    List<LectureCardDTO> popularLectures();
    List<LectureCardDTO> recentLectures();
    Page<LectureCardDTO> Lectures(LectureSearchParam lectureSearchParam, Pageable pageable);
    List<LectureCardDTO> getMyOpenLectures(UserEntity user);
    LectureDetailDTO getLectureDetail(Long id);
}
