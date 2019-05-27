package launcher;

import dal.UserDalImp;
import dto.Role;
import dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserLauncher {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/lits_cv_java_2?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "root";
	public static final String DB_COLUMN_ID = "id";
	public static final String DB_COLUMN_NAME = "name";
	public static final String DB_COLUMN_EMAIL = "email";
//	public static final String DB_COLUMN_ROLE_ID = "role_id";
//	public static final String DB_COLUMN_PASSWORD = "password";
//	public static final String DB_COLUMN_ADDRESS_ID = "address_id";

	public static void main(String[] args) {
		int i;

UserLauncher.initializeDriver();
				UserLauncher.readAllFromDB();

//			case 2:UserLauncher.initializeDriver();
//				UserLauncher.addNewRole("ROLE_SHOPPER","usual shopper");
//				break;
//			case 3:UserLauncher.initializeDriver();
//				UserLauncher.deleteOneRole("ROLE_SHOPPER");
//				break;
//			case 4:UserLauncher.initializeDriver();
//				UserLauncher.updateOneRole("usual shopper","shopper");
//				break;
		}


//		UserDalImp userDal = new UserDalImp();
//
//		List<User> userList = userDal.readAllFromDB();
//
//		userList.stream().forEach(x -> System.out.println(x));
//
//		Integer id = userList.get(0).getId();
//
//		userDal.deleteUser(id);
//
//		userList = userDal.readAllFromDB();
//
//		userList.stream().forEach(x -> System.out.println(x));
//	}

	public static void initializeDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void readAllFromDB() {

		List<User> userList = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			statement = connection.createStatement();

			String sqlQuery = "SELECT id, name, email FROM user;";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				Integer idValueFromDB = resultSet.getInt(DB_COLUMN_ID);
				String nameValueFromDB = resultSet.getString(DB_COLUMN_NAME);
				String emailValueFromDB = resultSet.getString(DB_COLUMN_EMAIL);
//				String role_idValueFromDB = resultSet.getString(DB_COLUMN_ROLE_ID);
//				String passwordValueFromDB = resultSet.getString(DB_COLUMN_PASSWORD);
//				String address_idValueFromDB = resultSet.getString(DB_COLUMN_ADDRESS_ID);

				User userFromDB = new User(idValueFromDB,nameValueFromDB);

				userFromDB.setEmail(emailValueFromDB);

				userList.add(userFromDB);

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		userList.forEach(System.out::println);

	}
}
