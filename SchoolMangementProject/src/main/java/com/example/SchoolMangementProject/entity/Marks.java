package com.example.SchoolMangementProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "marks")
public class Marks {
    @Id
    private  String marksId;
    @NonNull
    private  String studentId,examId;

    @NonNull
    private Map<Integer,Integer>marksobtained=new HashMap<>();
}
