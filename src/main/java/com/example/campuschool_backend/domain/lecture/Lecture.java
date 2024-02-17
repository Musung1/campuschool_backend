package com.example.campuschool_backend.domain.lecture;

import com.example.campuschool_backend.domain.auditing.AuditingField;
import com.example.campuschool_backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private UserEntity user;
    @OneToMany
    @JoinColumn(name = "register_id")
    private List<Register> registerList = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "curriculum_id")
    private List<Curriculum> curriculumList = new ArrayList<>();



}
