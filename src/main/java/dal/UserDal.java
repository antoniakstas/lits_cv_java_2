package dal;

import dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDal {

	List<User> readAllFromDB();

	Optional<User> readFromDBById(int id);

	boolean createUserInToDB(User user);

	boolean updateUser(int id, User user);

	boolean deleteUser(int id);
}
