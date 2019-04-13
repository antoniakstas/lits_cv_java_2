package dal;

import dto.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDal {
    List<Role> readAllFromDB();

    Optional<Role> readFromDBById(int id);

    boolean createRoleInDB(Role role);

    boolean updateRole(int id, Role role);

    boolean deleteRole(int id);


}
