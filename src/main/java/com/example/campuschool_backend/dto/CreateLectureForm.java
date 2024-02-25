package com.example.campuschool_backend.dto;

import com.example.campuschool_backend.domain.lecture.AvaliableTime;
import com.example.campuschool_backend.domain.lecture.CurriculumEntity;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class CreateLectureForm {
    private String title;
    private int day;
    private CategoryType categoryType;
    private Difficulty difficulty;
    private List<CurriculumEntity> curriculumEntityList;
    private List<AvaliableTime> avaliableTimeList;
}
