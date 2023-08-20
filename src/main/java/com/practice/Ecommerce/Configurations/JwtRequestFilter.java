package com.practice.Ecommerce.Configurations;


import com.practice.Ecommerce.Service.JwtService;
import com.practice.Ecommerce.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String header = request.getHeader("Authorization");
        String jwtToken = null;
        String userName = null;
        if (header !=null && header.startsWith("Bearer ")){
            jwtToken = header.substring(7);

            try {
               userName = jwtUtil.getUsernameFromToken(jwtToken);
            } catch (InterruptedException ie){
                System.out.println("Unable to get Jwt token");
            } catch (ExpiredJwtException e){
                System.out.println("Jwt token is expired");
            }
        } else {
            System.out.println("Jwt token does not start with Bearer");
        }


        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
               UserDetails userDetails =  jwtService.loadUserByUsername(userName);

               if (jwtUtil.validateToken())
        }
    }
}
