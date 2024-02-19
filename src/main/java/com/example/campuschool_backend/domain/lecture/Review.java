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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int rating;
    protected Review(){}
    public Review of(String content, int rating) {
        Review review = new Review();
        review.setContent(content);
        review.setRating(rating);
        return review;
    }
}
