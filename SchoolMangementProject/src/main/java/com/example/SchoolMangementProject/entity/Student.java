package com.example.SchoolMangementProject.entity;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String userId;
    private String rollNo;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String clazz; // class name/grade
    private String section;
    private LocalDate dob;

    private List<String> enrolledSubjects;

    @DBRef
    private  User user;
    @DBRef
    private Photo profileImage;
}

