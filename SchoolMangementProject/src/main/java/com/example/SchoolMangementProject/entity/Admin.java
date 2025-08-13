package com.example.SchoolMangementProject.entity;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "admins")
public class Admin {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;  // Should be encrypted with BCrypt
    private String role = "ADMIN"; // default role
}

