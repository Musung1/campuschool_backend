package com.example.campuschool_backend.service.impl;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.lecture.LectureCardDTO;
import com.example.campuschool_backend.dto.lecture.LectureSearchParam;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.service.LectureService;
import com.example.campuschool_backend.util.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    public Long createLecture(UserEntity user, CreateLectureForm createLectureForm) {
        Lecture lecture = Lecture.of(
                createLectureForm.getTitle(),
                createLectureForm.getRefImg(),
                createLectureForm.getDescription(),
                createLectureForm.getDay(),
                createLectureForm.getCategoryType(),
                createLectureForm.getDifficulty(),
                createLectureForm.getCurriculumList(),
                createLectureForm.getAvaliableTimeList(),
                user);
        Lecture savedLecture = lectureRepository.save(lecture);
        return savedLecture.getId();
    }

    @Override
    public List<LectureCardDTO> popularLectures() {
        return lectureRepository.findPopularLectures().stream().map((LectureCardDTO::from)).toList();
    }

    @Override
    public List<LectureCardDTO> recentLectures() {
        return lectureRepository.findRecentLectures().stream().map((LectureCardDTO::from)).toList();
    }

    @Override
    public Page<LectureCardDTO> Lectures(LectureSearchParam lectureSearchParam, Pageable pageable) {
        Page<Lecture> lectures = lectureRepository.findLectures(lectureSearchParam,pageable);
        return lectures.map((LectureCardDTO::from));
    }

}
