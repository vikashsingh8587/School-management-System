package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.ClassEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ClassRepo extends MongoRepository<ClassEntity,String> {
    Optional<ClassEntity> findByClassNameAndSection(String className, String section);
    List<ClassEntity> findByClassTeacherId(String teacherId);


}
