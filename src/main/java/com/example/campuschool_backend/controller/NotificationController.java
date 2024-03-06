package com.example.campuschool_backend.controller;

import com.example.campuschool_backend.dto.lecture.CreateNotificationForm;
import com.example.campuschool_backend.dto.lecture.NotificationDTO;
import com.example.campuschool_backend.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user/open")
@RestController
public class NotificationController {
    private final LectureService lectureService;
    @GetMapping("/{id}/notification")
    public ResponseEntity<Page<NotificationDTO>> getNotifications(@PathVariable Long id,
                                                                  @PageableDefault Pageable pageable) {
        Page<NotificationDTO> notificationDTOS = lectureService.getNotifications(id,pageable);
        return ResponseEntity.ok(notificationDTOS);
    }
    @PostMapping("/{id}/notification")
    public ResponseEntity<NotificationDTO> postNotifications(@PathVariable Long id,
                                                             @RequestBody CreateNotificationForm createNotificationForm) {
        NotificationDTO notificationDTO = lectureService.postNotifications(id,createNotificationForm);
        return ResponseEntity.ok(notificationDTO);
    }

}
