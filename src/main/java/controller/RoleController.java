package controller;

import dal.RoleDal;
import dal.RoleDalImp;
import dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    @Qualifier(value="roleDal")
    private RoleDal roleDal;

    @GetMapping(path = "/list")
    public void findAll() {

        List<Role> roleList = roleDal.readAllFromDB();
        System.out.println("here");

    }
}
