package dal;

import dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDal {

	List<User> readAllFromDB();

	Optional<User> readFromDBById(int id);

	public User createUserInToDB(User user);

	public User updateUser( User user);

	public void deleteUser(Integer id);
	public List<User> readAllFromDBById(Integer IdValue);
	public List<User> readAllFromDBByName(String userName);
}
