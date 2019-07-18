package dal;

import dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDalImp implements UserDal {
	private static final Logger logger = LoggerFactory.getLogger(UserDalImp.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	@Override
	@Transactional
	public List<User> readAllFromDB() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from user").list();
		return userList;

	}

	@Override
	@Transactional
	public Optional<User> readFromDBById(int id) {

		return Optional.empty();
	}

	@Override
	@Transactional
	public User createUserInToDB(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);

        logger.info("User saved successfully, User Details=" + user);
        return user;
	}

	@Override
	@Transactional
	public User updateUser( User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated successfully, User Details=" + user);
        return user;
	}

	@Override
	public void deleteUser(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (null != user) {
            session.delete(user);
            logger.info("User deleted successfully, User Details=" + user);
        }
	}
	@Override
	@Transactional
	public List<User> readAllFromDBById(Integer IdValue) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = (List<User>) session
				.createQuery(
						"select u from dto.User u " +
								"where u.id = :abc")
				.setParameter("abc", IdValue)
				.list();
		return userList;
	}
}
