package com.example.campuschool_backend.repository.impl;

import com.example.campuschool_backend.domain.lecture.Lecture;
import com.example.campuschool_backend.domain.lecture.QLecture;
import com.example.campuschool_backend.repository.CustomLectureRepository;
import com.example.campuschool_backend.repository.LectureRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureRepositoryImpl implements CustomLectureRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Lecture> findPopularLectures() {
        QLecture qLecture = new QLecture("l");
        return queryFactory.selectFrom(qLecture)
                .orderBy(qLecture.views.desc())
                .limit(5)
                .fetch();
    }
}
