package com.example.campuschool_backend.domain.lecture;

import com.example.campuschool_backend.domain.auditing.AuditingField;
import com.example.campuschool_backend.domain.lecture.enums.RegisterStatus;
import com.example.campuschool_backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Register extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private RegisterStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    protected Register() {}
    public static Register of(UserEntity user) {
        Register register = new Register();
        register.setStatus(RegisterStatus.WAIT);
        register.setUser(user);
        return register;
    }

}
