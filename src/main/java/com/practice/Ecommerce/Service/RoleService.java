package com.practice.Ecommerce.Service;

import com.practice.Ecommerce.Entity.RoleEntity;
import com.practice.Ecommerce.Repository.RoleRepository;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

   private final RoleRepository roleRepository;

   public RoleService(RoleRepository roleRepository){
       this.roleRepository = roleRepository;
   }

   public void createNewRole(RoleEntity userRole){  ///this UserRole means the entity role I have created it will return the role entity
        roleRepository.save(userRole);
   }
}
