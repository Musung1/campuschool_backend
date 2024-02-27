package com.example.campuschool_backend.dto;

import com.example.campuschool_backend.domain.lecture.AvaliableTime;
import com.example.campuschool_backend.domain.lecture.CurriculumEntity;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateLectureForm {
    private String title;
    private int day;
    private String description;
    private CategoryType categoryType;
    private Difficulty difficulty;
    private List<CurriculumEntity> curriculumList;
    private List<AvaliableTime> avaliableTimeList;

}
