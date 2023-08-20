package com.practice.Ecommerce.Controller;

import com.practice.Ecommerce.Entity.UserRegisterEntity;
import com.practice.Ecommerce.Service.UserRegisterService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    private final UserRegisterService userRegisterService;

    public UserController(UserRegisterService userRegisterService){
        this.userRegisterService = userRegisterService;
    }


    @PostMapping("/registerUser")
    public String RegisterUser(@Valid @RequestBody UserRegisterEntity userRegisterEntity){
        userRegisterService.RegisterUser(userRegisterEntity);
        return "user has been register";
    }

    @PostConstruct
    public void adminAndUserRoles(){
        userRegisterService.adminAndUserRoles();
    }


    @GetMapping("/admin")  // setting up the URl for the admin
    public String forAdmin(){
        return "This is admin dashboard";
    }

    @GetMapping("/user")     // setting up the URl for the user
    public String forUser(){
        return "This is used dashboard";
    }
}
