package com.example.campuschool_backend.domain.lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int index;
    private String title;
    private String description;
    protected Curriculum() {}
    public static Curriculum of(int index, String title, String description) {
        Curriculum curriculum = new Curriculum();
        curriculum.setIndex(index);
        curriculum.setTitle(title);
        curriculum.setDescription(description);
        return curriculum;
    }
}
