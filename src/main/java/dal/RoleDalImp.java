package dal;

import dto.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoleDalImp implements RoleDal {
    private static final Logger logger = LoggerFactory.getLogger(RoleDalImp.class);

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
    @Transactional
    public Role createRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(role);
        logger.info("Role saved successfully, Role Details = " + role);
        return role;
    }

    @Override
    @Transactional
    public Role updateRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role updated successfully, Role Details=" + role);
        return role;
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, Long.valueOf(id));
        if (role != null) {
            session.delete(role);
            logger.info("Role deleted successfully, Role Details=" + role);
        }
    }



}
