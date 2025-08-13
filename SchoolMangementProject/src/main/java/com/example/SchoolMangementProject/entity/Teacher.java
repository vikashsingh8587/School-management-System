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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "teachers")
public class Teacher {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dob;
    private String address;

    private String qualification;
    private int experienceYears;
    private List<String> subjectIds;
    private List<String> classIds;

    private String profileImage;
}

