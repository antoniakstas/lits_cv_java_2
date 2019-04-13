package dal;

import dto.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDalImp implements RoleDal{
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_ID = "id";
    public static final String DB_COLUMN_NAME = "name";
    public static final String DB_COLUMN_DESCRIPTION = "description";

    public RoleDalImp(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Role> readAllFromDB(){

        List<Role> roleList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM role;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_ID);
                String nameValueFromDB = resultSet.getString(DB_COLUMN_NAME);
                String descriptionValueFromDB = resultSet.getString(DB_COLUMN_DESCRIPTION);

                Role roleFromDB = new Role(idValueFromDB,nameValueFromDB,descriptionValueFromDB);
                roleList.add(roleFromDB);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Optional<Role> readFromDBById(int id) {

//        Optional<Role> optionalRole = new Optional<>();
//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            statement = connection.createStatement();
//
//            String sqlQuery = "SELECT * FROM role WHERE (`"+DB_COLUMN_ID+"` = '"+id+"';";
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            while (resultSet.next()) {
//                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_ID);
//                String nameValueFromDB = resultSet.getString(DB_COLUMN_NAME);
//                String descriptionValueFromDB = resultSet.getString(DB_COLUMN_DESCRIPTION);
//
//                Role roleFromDBById = new Role(idValueFromDB,nameValueFromDB,descriptionValueFromDB);
////                optionalRole.toString();
//
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return optionalRole;
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
