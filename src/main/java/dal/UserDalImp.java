package dal;

import dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDalImp implements UserDal {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/lits_cv_java_2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "root";
	public static final String DB_COLUMN_USER_ID = "id";
	public static final String DB_COLUMN_USER_NAME = "name";
	public static final String DB_COLUMN_USER_EMAIL = "email";
	public static final String DB_COLUMN_USER_ROLE_ID = "role_id";
	public static final String DB_COLUMN_USER_PASSWORD = "password";

	public UserDalImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAllFromDB() {
		Connection connection = null;
		Statement statement = null;
		List<User> userList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			statement = connection.createStatement();

			String sqlQuery = "SELECT * FROM user";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				Integer id = resultSet.getInt(DB_COLUMN_USER_ID);
				String name = resultSet.getString(DB_COLUMN_USER_NAME);
				String email = resultSet.getString(DB_COLUMN_USER_EMAIL);
				String role_id = resultSet.getString(DB_COLUMN_USER_ROLE_ID);
				String password = resultSet.getString(DB_COLUMN_USER_PASSWORD);

				User user = new User(id, name);
				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public Optional<User> readFromDBById(int id) {
		Connection connection = null;
		Statement statement = null;
		List<User> userList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			statement = connection.createStatement();

			String sqlQuery = "SELECT * FROM user WHERE ID = "+ id;
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				Integer idFromDB = resultSet.getInt(DB_COLUMN_USER_ID);
				String name = resultSet.getString(DB_COLUMN_USER_NAME);
				String email = resultSet.getString(DB_COLUMN_USER_EMAIL);
				String role_id = resultSet.getString(DB_COLUMN_USER_ROLE_ID);
				String password = resultSet.getString(DB_COLUMN_USER_PASSWORD);

				User user = new User(id, name);

				return Optional.of(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}




		return Optional.empty();
	}

	@Override
	public boolean createUserInToDB(User user) {
		return false;
	}

	@Override
	public boolean updateUser(int id, User user) {
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		return false;
	}
}
