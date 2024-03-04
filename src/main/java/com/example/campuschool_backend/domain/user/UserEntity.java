package com.example.campuschool_backend.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
    @Enumerated(value = EnumType.STRING)
    private LoginType loginType;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Description description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    protected  UserEntity(){}
    public static UserEntity of(String username,String password, String name, LoginType loginType,RoleType roleType) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setName(name);
        userEntity.setLoginType(loginType);
        userEntity.setRoleType(roleType);
        return userEntity;
    }
}
