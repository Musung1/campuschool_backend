package com.example.campuschool_backend.domain.lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class CurriculumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num;
    private String content;

    protected CurriculumEntity() {}
    public static CurriculumEntity of(int num, String content) {
        CurriculumEntity curriculumEntity = new CurriculumEntity();
        curriculumEntity.setNum(num);
        curriculumEntity.setContent(content);
        return curriculumEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurriculumEntity that = (CurriculumEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
