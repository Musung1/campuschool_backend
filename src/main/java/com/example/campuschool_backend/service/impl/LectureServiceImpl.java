package com.example.campuschool_backend.service.impl;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.CreateLectureForm;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.repository.UserRepository;
import com.example.campuschool_backend.service.LectureService;
import com.example.campuschool_backend.service.UserService;
import com.example.campuschool_backend.util.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    public Long createLecture(CreateLectureForm createLectureForm) {
        UserEntity user = null;
        String refImg = FileUpload.local(createLectureForm.getImg());
        Lecture lecture = Lecture.of(
                createLectureForm.getTitle(),
                refImg,
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

}
