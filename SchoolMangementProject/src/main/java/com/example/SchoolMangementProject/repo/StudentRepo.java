package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Student;
import com.example.SchoolMangementProject.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student, String> {

    List<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String name1);

    List<Student> findByClazz(String clazz);
}
