package com.example.SchoolMangementProject.filter;

import com.example.SchoolMangementProject.service.Userdetailservices;
import com.example.SchoolMangementProject.utility.JWT;
import io.jsonwebtoken.Jwt;
import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Data

public class JwtFilter extends OncePerRequestFilter {
    private  final JWT jwtUtility;
    private  final Userdetailservices userdetailservices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("hy are in jwt fileter");
        /*
        * Authorization ek HTTP header hai jo authentication credentials bhejne ke liye use hota hai.
        * JWT authentication me, is header me usually 'Bearer <jwt_token>' format me token store hota hai.*/
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println("authorizationHeader  :  "+authorizationHeader);
        String userId = null;
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);

            userId = jwtUtility.extractUsername(jwt);

        }
        if (userId != null) {
            UserDetails userDetails = userdetailservices.loadUserByUsername(userId);

            if (jwtUtility.validateToken(jwt)) {
                System.out.println("vaided");
                /*
                * UsernamePasswordAuthenticationToken me teen cheeze hoti h

Principal → Usually user ka detail object (yaha userDetails)

Credentials → Password (yaha null kyunki token validate ho chuka hai, password ki zarurat nahi)

Authorities → User ke roles/permissions (yaha userDetails.getAuthorities())

Ye user authenticated hai, aur iske ye roles/permissions hain."
                * */
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                System.out.println("username password are valid ");
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println("auth :0 "  +auth);
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("store in security"+SecurityContextHolder.getContext().getAuthentication().getName());
            }
        }
        chain.doFilter(request, response);
        System.out.println("done");
    }
}
