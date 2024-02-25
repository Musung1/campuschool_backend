package com.example.campuschool_backend.domain.lecture;

import com.example.campuschool_backend.domain.auditing.AuditingField;
import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.domain.lecture.enums.Difficulty;
import com.example.campuschool_backend.domain.lecture.enums.LectureStatus;
import com.example.campuschool_backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Lecture extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private CategoryType categoryType;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    private String refImage;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private LectureStatus lectureStatus;
    private int day;
    private int views;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity teacher;
    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<Register> registerList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id")
    private List<CurriculumEntity> curriculumEntityList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id")
    private List<AvaliableTime> avaliableTimeList = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<Review> reviewList = new ArrayList<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(id, lecture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    protected Lecture() {}
    public static Lecture of(String title, CategoryType categoryType, Difficulty difficulty,UserEntity user) {
        Lecture lecture = new Lecture();
        lecture.setTitle(title);
        lecture.setCategoryType(categoryType);
        lecture.setDifficulty(difficulty);
        lecture.setTeacher(user);
        return lecture;
    }
    public static Lecture of(String title,
                             int day,
                             CategoryType categoryType,
                             Difficulty difficulty,
                             List<CurriculumEntity> curriculumEntityList,
                             List<AvaliableTime> avaliableTimeList,
                             UserEntity user) {
        Lecture lecture = new Lecture();
        lecture.setTitle(title);
        lecture.setDay(day);
        lecture.setCategoryType(categoryType);
        lecture.setDifficulty(difficulty);
        lecture.setCurriculumEntityList(curriculumEntityList);
        lecture.setAvaliableTimeList(avaliableTimeList);
        lecture.setTeacher(user);
        return lecture;
    }
}
