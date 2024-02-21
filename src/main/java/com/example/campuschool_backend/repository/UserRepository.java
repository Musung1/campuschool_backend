package com.example.campuschool_backend.repository;

import com.example.campuschool_backend.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
