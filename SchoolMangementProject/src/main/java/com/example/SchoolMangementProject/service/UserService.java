package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.dto.Login_Request;
import com.example.SchoolMangementProject.dto.Login_reponse;
import com.example.SchoolMangementProject.entity.Role;
import com.example.SchoolMangementProject.entity.User;
import com.example.SchoolMangementProject.repo.UserRepo;
import com.example.SchoolMangementProject.utility.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  EmailVerify email;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Userdetailservices userdetailservices;

    @Autowired
    private JWT jwt;
    @Autowired
    private  SequenceGenerator sequenceGenerator;


    public Boolean  saveNewUser(User user){
        try {
            System.out.println("User email: " + user.getEmail());

            Boolean flag = email.emailVerify(user.getEmail());

            System.out.println("Is email valid? " + flag);

            if (flag) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                long seq= sequenceGenerator.generateSequence("user_sequence");
                String userId= String.format("us%03d",seq);
                user.setUserId(userId);
                userRepo.save(user);
                System.out.println("User saved");
                return true;
            } else {
                System.out.println("Email invalid, not saving user.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Email is not valid: " + e.getMessage());
        }
       return  false;
    }

    public  Login_reponse LogInUser(Login_Request login_request){
        try{
           //authentication mangaer user of verifed karta ha ki jo userid or password diya hu wo sahi h ya glt
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login_request.getUserId(),login_request.getPassword()));
            System.out.println("hello");
           //Userdetail user ka detail load krta h isme username,password,roll hota h iske custom bhi bna skte h
            final UserDetails userDetails= userdetailservices.loadUserByUsername(login_request.getUserId());
            System.out.println("detail loaded");
            User user = userRepo.findByUserId(login_request.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
      String userrole= user.getRole().name();

            final String token = jwt.generateToken(user.getUserId(), userrole);


            System.out.println("token generate");
            System.out.println("token  :" +token);
            return  new Login_reponse(token);

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
