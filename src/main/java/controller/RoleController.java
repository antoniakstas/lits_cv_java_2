package controller;

import dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.RoleService;

import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = "/add")
    public Role createRole(@ModelAttribute("role") Role role) {

        Optional<Role> roleWasCreated = this.roleService.createRole(role);


        if (roleWasCreated.isPresent()) {
            return roleWasCreated.get();

        }

        return null;
    }

    @PostMapping(value = "/update")
    public Role updateRole(@ModelAttribute("role") Role role){

        Optional<Role> roleWasUpdated = this.roleService.updateRole(role);

        if (roleWasUpdated.isPresent()){
            return roleWasUpdated.get();
        }

        return null;
    }
}
