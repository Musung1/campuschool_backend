package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Long>,CustomLectureRepository {
}
