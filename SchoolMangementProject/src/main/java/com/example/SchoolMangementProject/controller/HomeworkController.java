package com.example.SchoolMangementProject.controller;

import com.example.SchoolMangementProject.entity.Homework;
import com.example.SchoolMangementProject.service.HomeWorkService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/homework")
@Data
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeWorkService homeworkService;

    @GetMapping("/class/{className}")
    public ResponseEntity<List<Homework>> getByClass(@PathVariable String className) {
        return ResponseEntity.ok(homeworkService.getHomeworksForClass(className));
    }

    @PostMapping("/submit/{homeworkId}")
    public ResponseEntity<Homework> submitHomework(
            @PathVariable String homeworkId,
            @RequestParam String studentId,
            @RequestParam String submissionFileUrl) {
        // submissionFileUrl can be a pre-signed S3 URL or local path after upload
        return ResponseEntity.ok(homeworkService.submitHomework(homeworkId, studentId, submissionFileUrl));
    }
}

