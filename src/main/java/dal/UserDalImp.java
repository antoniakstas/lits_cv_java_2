package dal;

import dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
	public boolean createUserInToDB(User user) {
		return false;
	}

	@Override
	@Transactional
	public boolean updateUser(int id, User user) {
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		return false;
	}
}
