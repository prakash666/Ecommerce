package com.practice.Ecommerce.Controller;
import com.practice.Ecommerce.Entity.RoleEntity;
import com.practice.Ecommerce.Service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleService roleService; // dependency injection

    public RoleController(RoleService roleService){  // dependency injection
        this.roleService = roleService;
    }

    @PostMapping("/createNewRole")
    public String createNewRole(@RequestBody RoleEntity userRoll)
    {
        roleService.createNewRole(userRoll);
        return "Roles has been posted";
    }
}
