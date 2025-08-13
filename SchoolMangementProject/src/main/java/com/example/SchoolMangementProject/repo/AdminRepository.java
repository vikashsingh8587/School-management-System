package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;



import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByEmail(String email);
}

