package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.ExamResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExamResultRepository extends MongoRepository<ExamResult,String> {
    List<ExamResult> findByStudentId(String studentId);
    List<ExamResult> findByExamName(String examName);
}
