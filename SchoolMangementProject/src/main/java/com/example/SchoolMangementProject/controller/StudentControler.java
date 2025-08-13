package com.example.SchoolMangementProject.controller;



import com.example.SchoolMangementProject.entity.Student;
import com.example.SchoolMangementProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/students")
public class StudentControler {

    @Autowired
    private StudentService studentService;



    // Create new student
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestPart("student") Student student, @RequestPart("photo") MultipartFile photo)throws  Exception {
        return ResponseEntity.ok(studentService.createStudent(student,photo));
    }

    // Get all students
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Get student by ID
    @PreAuthorize("hasRole('ADMIN','TEACHER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {

        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @GetMapping("/profile")
    public ResponseEntity<?> getStudentProfile() {
        String id= SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(studentService.getStudentById(id));

    }
    @PreAuthorize("hasRole('ADMIN','TEACHER')")
    @GetMapping("/profile")
    public ResponseEntity<?> getStudentProfile(String id) {

        return ResponseEntity.ok(studentService.getStudentById(id));

    }
    // Update student by ID
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    // Delete student by ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

