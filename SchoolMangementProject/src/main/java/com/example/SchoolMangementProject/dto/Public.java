package com.example.SchoolMangementProject.dto;


import com.example.SchoolMangementProject.entity.Teacher;
import com.example.SchoolMangementProject.entity.User;

import com.example.SchoolMangementProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/public")
public class Public {
    @Autowired
    private UserService userService;





    @PostMapping("/sign-up")
    public ResponseEntity<?> saveUser(@RequestBody User user ){
        try{
            System.out.println("hello we are ready");
            return  ResponseEntity.ok(userService.saveNewUser(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/log-in")
    public  ResponseEntity<?>Log_in(@RequestBody Login_Request login_request){
        try{
            System.out.println("hello we are in login ready");
            return   ResponseEntity.ok(userService.LogInUser(login_request));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
