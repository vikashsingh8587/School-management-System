package com.example.SchoolMangementProject.entity;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Data
@Document(collection = "attendances")
public class Attendance {
    @Id
    private String id;
    private String studentId;
    private LocalDate date;
    private boolean present;
    private String remark; // reason if absent
}
