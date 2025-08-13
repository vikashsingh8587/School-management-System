package com.example.SchoolMangementProject.entity;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Document(collection = "classes")
public class ClassEntity {
    @Id
    private String id;

    private String className;
    private String section;
    private String classTeacherId;

    private List<String> subjectIds;
}

