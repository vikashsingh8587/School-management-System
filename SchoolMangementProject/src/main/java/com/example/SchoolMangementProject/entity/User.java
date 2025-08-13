package com.example.SchoolMangementProject.entity;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    @NonNull
    private String username;
    @NonNull
    private String password;

    @NonNull
    private  String email;
    private  Role role;


@DBRef
    private  Student student;

}
