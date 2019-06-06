package service;

import dal.RoleDal;
import dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public Optional<Role> createRole(Role role) {
        Long roleId = role.getId();
        boolean roleIdIsInDB = false;
        List<Role> roleList = roleDal.readAllFromDB();
        for (Role role1 : roleList) {
            if (roleId == role1.getId()) {
                roleIdIsInDB = true;
                break;
            }
        }

        if (!roleIdIsInDB) {
            return Optional.of(this.roleDal.createRole(role));
        }
        return Optional.of(new Role());
    }

    @Override
    @Transactional
    public Optional<Role> updateRole(Role role) {

        this.roleDal.updateRole(role);

        return Optional.of(this.roleDal.updateRole(role));
    }

    @Override
    @Transactional
    public Optional<Role> deleteLine(Long id) {
        roleDal.deleteRole(id);

        return null;
    }
}
