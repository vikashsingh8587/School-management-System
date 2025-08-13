package com.example.SchoolMangementProject.controller;

import com.example.SchoolMangementProject.entity.Marks;
import com.example.SchoolMangementProject.service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarksController {

    private final MarksService marksService;

    // Create Marks
    @PostMapping
    public ResponseEntity<Marks> createMarks(@RequestBody Marks marks) {
        return ResponseEntity.ok(marksService.createMarks(marks));
    }

    // Get All Marks
    @GetMapping
    public ResponseEntity<List<Marks>> getAllMarks() {
        return ResponseEntity.ok(marksService.getAllMarks());
    }

    // Get Marks by ID
    @GetMapping("/{id}")
    public ResponseEntity<Marks> getMarksById(@PathVariable String id) {
        return ResponseEntity.ok(marksService.getMarksById(id));
    }

    // Get Marks by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Marks>> getMarksByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(marksService.getMarksByStudentId(studentId));
    }

    // Get Marks by Exam ID
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Marks>> getMarksByExamId(@PathVariable String examId) {
        return ResponseEntity.ok(marksService.getMarksByExamId(examId));
    }

    // Update Marks
    @PutMapping("/{id}")
    public ResponseEntity<Marks> updateMarks(@PathVariable String id, @RequestBody Marks marks) {
        return ResponseEntity.ok(marksService.updateMarks(id, marks));
    }

    // Delete Marks
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarks(@PathVariable String id) {
        marksService.deleteMarks(id);
        return ResponseEntity.ok("Marks deleted successfully");
    }
}
