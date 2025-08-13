package com.example.SchoolMangementProject.controller;



import com.example.SchoolMangementProject.entity.ExamResult;
import com.example.SchoolMangementProject.service.ExamResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ExamResultController {

    private final ExamResultService examResultService;

    // Create Exam Result
    @PostMapping
    public ResponseEntity<ExamResult> createExamResult(@RequestBody ExamResult examResult) {
        return ResponseEntity.ok(examResultService.createExamResult(examResult));
    }

    // Get All Exam Results
    @GetMapping
    public ResponseEntity<List<ExamResult>> getAllExamResults() {
        return ResponseEntity.ok(examResultService.getAllExamResults());
    }

    // Get Exam Result by ID
    @GetMapping("/{id}")
    public ResponseEntity<ExamResult> getExamResultById(@PathVariable String id) {
        return ResponseEntity.ok(examResultService.getExamResultById(id));
    }

    // Get Results by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ExamResult>> getResultsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(examResultService.getResultsByStudentId(studentId));
    }

    // Get Results by Exam Name
    @GetMapping("/exam/{examName}")
    public ResponseEntity<List<ExamResult>> getResultsByExamName(@PathVariable String examName) {
        return ResponseEntity.ok(examResultService.getResultsByExamName(examName));
    }

    // Update Exam Result
    @PutMapping("/{id}")
    public ResponseEntity<ExamResult> updateExamResult(@PathVariable String id, @RequestBody ExamResult examResult) {
        return ResponseEntity.ok(examResultService.updateExamResult(id, examResult));
    }

    // Delete Exam Result
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExamResult(@PathVariable String id) {
        examResultService.deleteExamResult(id);
        return ResponseEntity.ok("Exam result deleted successfully");
    }
}

