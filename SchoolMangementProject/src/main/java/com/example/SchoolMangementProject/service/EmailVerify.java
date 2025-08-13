package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmailVerify {

    @Value("${email}")
    private  String  emailReg;

    public boolean emailVerify(String mail) {
        System.out.println("Regex: " + emailReg);
        System.out.println("Email: " + mail);

        if (mail == null || emailReg == null) {
            return false;
        }

        boolean result = mail.matches(emailReg);
        System.out.println("Match result: " + result);
        return result;
    }





}
