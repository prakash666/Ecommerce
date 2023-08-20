package com.practice.Ecommerce.Service;


import com.practice.Ecommerce.Entity.RoleEntity;
import com.practice.Ecommerce.Entity.UserRegisterEntity;
import com.practice.Ecommerce.Repository.RoleRepository;
import com.practice.Ecommerce.Repository.UserRegisterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserRegisterService {


    @Autowired
    public UserRegisterRepository userRegisterRepository;

    @Autowired
    public RoleRepository roleRepository;
    public void RegisterUser(UserRegisterEntity userRegisterEntity){
        userRegisterRepository.save(userRegisterEntity);
    }

    public void adminAndUserRoles() {
        RoleEntity admin = new RoleEntity();
        admin.setRoleName("admin");
        admin.setRoleDescription("this is admin dashboard");
        roleRepository.save(admin);

        RoleEntity user = new RoleEntity();
        user.setRoleName("username");
        user.setRoleDescription("this is user dashboard");
        roleRepository.save(user);

        UserRegisterEntity adminRoles = new UserRegisterEntity();
        adminRoles.setFirstName("admin");
        adminRoles.setLastName("admin");
        adminRoles.setAge("23");
        adminRoles.setEmail("admin@gmail.com");
        adminRoles.setAddress("kathmandu");
        adminRoles.setUserPhoneNumber("774-696-9882");
        adminRoles.setPassword("admin@123s");
        Set<RoleEntity> rolesAdmin = new HashSet<>();
        rolesAdmin.add(admin);
        adminRoles.setRole(rolesAdmin);
        userRegisterRepository.save(adminRoles);

        UserRegisterEntity userRoles = new UserRegisterEntity();
        userRoles.setFirstName("prakash");
        userRoles.setLastName("dangi");
        userRoles.setAge("23");
        userRoles.setEmail("dangip1000@gmail.com");
        userRoles.setAddress("kathmandu");
        userRoles.setUserPhoneNumber("774-6969882");
        userRoles.setPassword("prakash@2056");
        Set<RoleEntity> rolesUser = new HashSet<>();
        rolesUser.add(user);
        userRoles.setRole(rolesUser);
        userRegisterRepository.save(userRoles);



    }










}
