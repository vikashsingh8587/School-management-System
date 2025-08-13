package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo,String> {

}
