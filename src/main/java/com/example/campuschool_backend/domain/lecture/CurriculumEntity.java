package com.example.campuschool_backend.domain.lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
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
    private String title;
    private String description;
    protected CurriculumEntity() {}
    public static CurriculumEntity of(int num, String title, String description) {
        CurriculumEntity curriculumEntity = new CurriculumEntity();
        curriculumEntity.setNum(num);
        curriculumEntity.setTitle(title);
        curriculumEntity.setDescription(description);
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
