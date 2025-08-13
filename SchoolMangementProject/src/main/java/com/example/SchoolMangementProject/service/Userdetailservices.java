package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.User;
import com.example.SchoolMangementProject.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Userdetailservices implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user= userRepo.findByUserId(username).orElseThrow(()->new UsernameNotFoundException("username not fournt"+ username));
        return  new org.springframework.security.core.userdetails.User(
                user.getUserId(),
                user.getPassword(),
                Collections.singleton(()->"Role"+user.getRole())

        );

    }

}
