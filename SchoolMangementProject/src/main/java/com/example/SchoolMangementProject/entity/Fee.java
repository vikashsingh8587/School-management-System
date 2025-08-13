package com.example.SchoolMangementProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "fees")
public class Fee {
    @Id
    private String id;
    private String studentId;
    private Double amount;
    private LocalDate dueDate;
    private Boolean paid;
    private LocalDate paidAt;
    private String paymentReference;


}

