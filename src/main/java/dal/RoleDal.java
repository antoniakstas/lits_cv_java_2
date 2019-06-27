package dal;

import dto.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDal {
    List<Role> readAllFromDB();

    Optional<Role> readFromDBById(int id);

    public Role createRole(Role role);

    public Role updateRole(Role role);

    void deleteRole(Long id);


}
