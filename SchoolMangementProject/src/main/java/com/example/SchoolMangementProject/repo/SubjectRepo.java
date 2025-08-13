package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubjectRepo extends MongoRepository<Subject,String> {
    Optional<Object> findByCode(String code);
}
