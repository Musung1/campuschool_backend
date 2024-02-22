package com.example.campuschool_backend.domain.lecture;

import com.example.campuschool_backend.domain.auditing.AuditingField;
import com.example.campuschool_backend.domain.lecture.enums.Days;
import com.example.campuschool_backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AvaliableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Days days;
    private String time;
    private Long registerBy;

    protected AvaliableTime(){}
    public static AvaliableTime of(Days days, String time) {
        AvaliableTime avaliableTime = new AvaliableTime();
        avaliableTime.setDays(days);
        avaliableTime.setTime(time);
        return avaliableTime;
    }
}
