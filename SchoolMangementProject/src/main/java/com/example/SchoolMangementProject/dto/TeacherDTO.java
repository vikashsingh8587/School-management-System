package com.example.SchoolMangementProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDTO {
    private  String  name;
    private  String teacherId;
    private  String  qualificationDet;
    private  String classTeacher;
    private  String emailid;
}
