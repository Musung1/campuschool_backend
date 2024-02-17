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
    @ManyToOne
    @JoinColumn(name = "register_id")
    private UserEntity registerBy;
    @ManyToOne
    @JoinColumn(name = "open_id")
    private UserEntity openBy;

    protected AvaliableTime(){}
    public static AvaliableTime of(Days days, String time, UserEntity registerBy, UserEntity openBy) {
        AvaliableTime avaliableTime = new AvaliableTime();
        avaliableTime.setDays(days);
        avaliableTime.setTime(time);
        avaliableTime.setRegisterBy(registerBy);
        avaliableTime.setOpenBy(openBy);
        return avaliableTime;
    }
}
