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
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num;
    private String title;
    private String description;
    protected Curriculum() {}
    public static Curriculum of(int num, String title, String description) {
        Curriculum curriculum = new Curriculum();
        curriculum.setNum(num);
        curriculum.setTitle(title);
        curriculum.setDescription(description);
        return curriculum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
