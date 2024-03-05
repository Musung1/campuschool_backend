package com.example.campuschool_backend.service.impl;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.lecture.Register;
import com.example.campuschool_backend.domain.user.UserEntity;
import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.lecture.LectureCardDTO;
import com.example.campuschool_backend.dto.lecture.LectureDetailDTO;
import com.example.campuschool_backend.dto.lecture.LectureSearchParam;
import com.example.campuschool_backend.repository.LectureRepository;
import com.example.campuschool_backend.service.LectureService;
import com.example.campuschool_backend.util.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<LectureCardDTO> getMyOpenLectures(UserEntity user) {
        List<Lecture> lectures = lectureRepository.findMyOpenLectures(user.getId());
        return lectures.stream().map((LectureCardDTO::from)).toList();
    }
    @Override
    public LectureDetailDTO getLectureDetail(Long id) {
        Lecture lecture = lectureRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return LectureDetailDTO.builder()
                .day(lecture.getDay())
                .lectureDescription(lecture.getDescription())
                .lectureImage(lecture.getRefImage())
                .lectureTitle(lecture.getTitle())
                .curriculumEntityList(lecture.getCurriculumEntityList())
                .reviewList(lecture.getReviewList())
                .teacherDescription(lecture.getTeacher().getDescription().getDescription())
                .teacherEducation(lecture.getTeacher().getDescription().getEducation())
                .teacherHistory(lecture.getTeacher().getDescription().getHistory())
                .teacherImage(lecture.getTeacher().getImg())
                .teacherName(lecture.getTeacher().getName())
                .categoryType(lecture.getCategoryType())
                .avaliableTimeList(lecture.getAvaliableTimeList())
                .build();
    }
    @Transactional
    @Override
    public Long registerLecture(UserEntity userEntity, Long id) {
        Register register = Register.of(userEntity);
        Lecture lecture = lectureRepository.findById(id).orElseThrow(()-> new RuntimeException());
        if(lecture.checkDuplication(id)) {
            throw new RuntimeException();
        }
        lecture.addRegister(register);
        return register.getId();
    }

}
