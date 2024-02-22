package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.CreateLectureForm;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;

    public Long createLecture(CreateLectureForm createLectureForm) {
        UserEntity user = userRepository.findById(1L).orElseThrow(()-> new RuntimeException());
        Lecture lecture = Lecture.of(createLectureForm.getTitle(),
                createLectureForm.getCategoryType(),
                createLectureForm.getDifficulty(),
                createLectureForm.getCurriculumEntityList(),
                createLectureForm.getAvaliableTimeList(),
                user);
        Lecture savedLecture = lectureRepository.save(lecture);
        return savedLecture.getId();
    }

}
