package com.example.campuschool_backend.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String img;
    private String portfolioImg;
    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;
    private LoginType loginType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "description_id")
    private Description description;


    protected  UserEntity(){}
    public static UserEntity of(String username,String password, String name, LoginType loginType) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setName(name);
        userEntity.setLoginType(loginType);
        return userEntity;
    }
}
