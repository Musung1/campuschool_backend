package com.example.campuschool_backend.controller;

import com.example.campuschool_backend.dto.lecture.CreateLectureForm;
import com.example.campuschool_backend.dto.lecture.LectureCardDTO;
import com.example.campuschool_backend.service.LectureService;
import com.example.campuschool_backend.util.FileUpload;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("api/class")
@RestController
public class LectureController {
    private final LectureService lectureService;
    @PostMapping("/open")
    public ResponseEntity<CreateLectureForm> createLecture(
            @RequestParam("img") MultipartFile img,
            @ModelAttribute CreateLectureForm lectureForm,
            HttpServletRequest request) throws IOException {
        String refImg = FileUpload.local(img,request);
        lectureForm.setRefImg(refImg);
        Long id = lectureService.createLecture(lectureForm);
        return ResponseEntity.ok(lectureForm);
    }
    @GetMapping("/popular")
    public ResponseEntity<List<LectureCardDTO>> getPopularLecture() {
        List<LectureCardDTO> lectureCardDTOList = lectureService.popularLectures();
        return ResponseEntity.ok(lectureCardDTOList);
    }

}
