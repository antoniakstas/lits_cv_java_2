package controller;

import dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/list")
    public List<Role> findAll() {
        List<Role> allRoles = roleService.findAllRoles();
return allRoles;

    }
}
