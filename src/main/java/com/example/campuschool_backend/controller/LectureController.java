package com.example.campuschool_backend.controller;

import com.example.campuschool_backend.domain.lecture.enums.CategoryType;
import com.example.campuschool_backend.dto.CreateLectureForm;
import com.example.campuschool_backend.service.LectureService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("api/class")
@RestController
public class LectureController {
    private final LectureService lectureService;
    @PermitAll
    @PostMapping("/open")
    public ResponseEntity<CreateLectureForm> createLecture(@ModelAttribute CreateLectureForm lectureForm) {
        Long id = lectureService.createLecture(lectureForm);
        return ResponseEntity.ok(lectureForm);
    }

}
