package dal;

import dto.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoleDalImp implements RoleDal {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public List<Role> readAllFromDB() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> roleList = session.createQuery("from role").list();
        return roleList;
    }

    @Override
    public Optional<Role> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createRoleInDB(Role role) {
        return false;
    }

    @Override
    public boolean updateRole(int id, Role role) {
        return false;
    }

    @Override
    public boolean deleteRole(int id) {
        return false;
    }


}
