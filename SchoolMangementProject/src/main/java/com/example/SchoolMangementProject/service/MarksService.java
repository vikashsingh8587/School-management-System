package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Marks;
import com.example.SchoolMangementProject.repo.MarksReopsitory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarksService {

    private final MarksReopsitory marksRepository;

    // Create Marks
    public Marks createMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    // Get All Marks
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    // Get Marks by ID
    public Marks getMarksById(String id) {
        return marksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marks not found with ID: " + id));
    }

    // Get Marks by Student ID
    public List<Marks> getMarksByStudentId(String studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    // Get Marks by Exam ID
    public List<Marks> getMarksByExamId(String examId) {
        return marksRepository.findByExamId(examId);
    }

    // Update Marks
    public Marks updateMarks(String id, Marks updatedMarks) {
        Marks existing = getMarksById(id);

        existing.setStudentId(updatedMarks.getStudentId());
        existing.setExamId(updatedMarks.getExamId());
        existing.setMarksobtained(updatedMarks.getMarksobtained());

        return marksRepository.save(existing);
    }

    // Delete Marks
    public void deleteMarks(String id) {
        if (!marksRepository.existsById(id)) {
            throw new RuntimeException("Marks not found with ID: " + id);
        }
        marksRepository.deleteById(id);
    }
}
