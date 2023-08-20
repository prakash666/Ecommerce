package com.practice.Ecommerce.Configurations;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    public JwtRequestFilter jwtRequestFilter;

    @Autowired
    public UserDetailsService jwtService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                        .csrf(AbstractHttpConfigurer::disable);

               httpSecurity.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("").permitAll()
                                .requestMatchers(HttpHeaders.ALLOW).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());

    }




    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception {


//        httpSecurity
//                .cors(AbstractHttpConfigurer::disable);
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
//
//                })
//
//
//                .requestMatchers("").permitAll()
//                .requestMatchers((HttpHeaders.ALLOW)).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .exception().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                return httpSecurity.build();


