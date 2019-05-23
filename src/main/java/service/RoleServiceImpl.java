package service;

import dal.RoleDal;
import dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier(value = "roleDal")
    private RoleDal roleDal;

    @Override
    public List<Role> findAllRoles() {
        List<Role> roleList = roleDal.readAllFromDB();
        return roleList;
    }
}
