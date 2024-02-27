package com.example.campuschool_backend.service;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.CreateLectureForm;
import com.example.campuschool_backend.dto.SignUpForm;
import com.example.campuschool_backend.dto.UserDTO;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public Long createLecture(CreateLectureForm createLectureForm) {
        UserEntity user = null;
        Lecture lecture = Lecture.of(createLectureForm.getTitle(),
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
