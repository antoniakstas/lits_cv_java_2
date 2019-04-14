package launcher;

import dal.UserDalImp;
import dto.User;

import java.util.List;

public class
UserLauncher {

	public static void main(String[] args) {

		UserDalImp userDal = new UserDalImp();

		List<User> userList = userDal.readAllFromDB();

		userList.stream().forEach(x -> System.out.println(x));

	}
}
