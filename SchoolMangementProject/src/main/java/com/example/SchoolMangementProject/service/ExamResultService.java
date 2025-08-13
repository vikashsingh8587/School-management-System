package com.example.SchoolMangementProject.service;



import com.example.SchoolMangementProject.entity.ExamResult;
import com.example.SchoolMangementProject.repo.ExamResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamResultService {

    private final ExamResultRepository examResultRepository;

    // Create Exam Result
    public ExamResult createExamResult(ExamResult examResult) {
        calculateTotalAndGrade(examResult);
        return examResultRepository.save(examResult);
    }

    // Get All Exam Results
    public List<ExamResult> getAllExamResults() {
        return examResultRepository.findAll();
    }

    // Get Exam Result by ID
    public ExamResult getExamResultById(String id) {
        return examResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam Result not found with ID: " + id));
    }

    // Get Results by Student ID
    public List<ExamResult> getResultsByStudentId(String studentId) {
        return examResultRepository.findByStudentId(studentId);
    }

    // Get Results by Exam Name
    public List<ExamResult> getResultsByExamName(String examName) {
        return examResultRepository.findByExamName(examName);
    }

    // Update Exam Result
    public ExamResult updateExamResult(String id, ExamResult updatedResult) {
        ExamResult existing = getExamResultById(id);

        existing.setStudentId(updatedResult.getStudentId());
        existing.setExamName(updatedResult.getExamName());
        existing.setClassName(updatedResult.getClassName());
        existing.setSubjectMarks(updatedResult.getSubjectMarks());

        calculateTotalAndGrade(existing);

        return examResultRepository.save(existing);
    }

    // Delete Exam Result
    public void deleteExamResult(String id) {
        if (!examResultRepository.existsById(id)) {
            throw new RuntimeException("Exam Result not found with ID: " + id);
        }
        examResultRepository.deleteById(id);
    }

    // Helper: Calculate total marks and grade
    private void calculateTotalAndGrade(ExamResult result) {
        if (result.getSubjectMarks() != null && !result.getSubjectMarks().isEmpty()) {
            double total = result.getSubjectMarks().values().stream().mapToDouble(Double::doubleValue).sum();
            result.setTotalMarks(total);

            double percentage = total / result.getSubjectMarks().size();

            if (percentage >= 90) result.setGrade("A+");
            else if (percentage >= 80) result.setGrade("A");
            else if (percentage >= 70) result.setGrade("B+");
            else if (percentage >= 60) result.setGrade("B");
            else if (percentage >= 50) result.setGrade("C");
            else result.setGrade("F");
        }
    }
}

