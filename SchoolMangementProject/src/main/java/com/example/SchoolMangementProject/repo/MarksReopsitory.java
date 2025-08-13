package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MarksReopsitory extends MongoRepository<Marks,String> {
    List<Marks> findByStudentId(String studentId);
    List<Marks> findByExamId(String examId);
}
