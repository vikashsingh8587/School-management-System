package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Homework;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HomeWorkRepository extends MongoRepository<Homework,String> {
    List<Homework> findByClassName(String className);
}
