package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendenceRepository extends MongoRepository<Attendance,String> {
    List<Attendance> findByStudentId(String studentId);
    List<Attendance> findByDate(LocalDate date);
}
