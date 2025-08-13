package com.example.SchoolMangementProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String fromUserId; // teacher/admin
    private String toUserId; // student
    private String subject;
    private String body;
    private LocalDateTime sentAt;
    private boolean read;
}

