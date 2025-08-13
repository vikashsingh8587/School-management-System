package com.example.SchoolMangementProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Login_reponse {
    private  String token;

    public  Login_reponse(String token){
        this.token=token;
    }
}
