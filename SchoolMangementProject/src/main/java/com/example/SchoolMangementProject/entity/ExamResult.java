package com.example.SchoolMangementProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "results")
public class ExamResult {
    @Id
    private String id;
    private String studentId;
    private String examName;
    private String className;
    private Map<String, Double> subjectMarks; // subject -> marks
    private Double totalMarks;
    private String grade;
}
