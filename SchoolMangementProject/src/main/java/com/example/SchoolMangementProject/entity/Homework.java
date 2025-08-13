package com.example.SchoolMangementProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "homeworks")
public class Homework {
    @Id
    private String id;
    private String title;
    private String description;
    private String assignedByTeacherId;
    private String className;
    private LocalDateTime assignedAt;
    private LocalDateTime dueAt;

    // submission fields (simple model)
    private String submittedByStudentId;
    private String submissionFileUrl; // or filename
    private LocalDateTime submittedAt;
    private String status; // PENDING / SUBMITTED / MARKED
    private String teacherFeedback;
    private Double marks;
}
