package service;

import dto.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAllRoles();
    public Optional<Role> createRole(Role role);
    public Optional<Role> updateRole(Role role);
    public void deleteLine(Long id);

}
