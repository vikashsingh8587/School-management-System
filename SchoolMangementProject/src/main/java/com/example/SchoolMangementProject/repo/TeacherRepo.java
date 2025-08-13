package com.example.SchoolMangementProject.repo;


import com.example.SchoolMangementProject.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepo extends MongoRepository<Teacher,String> {
    Optional<Teacher> findByEmail(String email);
    List<Teacher> findBySubjectIdsContaining(String subjectId);
}
