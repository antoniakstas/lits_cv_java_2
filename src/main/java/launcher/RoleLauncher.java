package launcher;

import dto.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoleLauncher {
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_ID = "id";
    public static final String DB_COLUMN_NAME = "name";
    public static final String DB_COLUMN_DESCRIPTION = "description";

    public static void main(String[] args) {
        int i;

        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();

            switch (i){
                case 1:RoleLauncher.initializeDriver();
                    RoleLauncher.readAllFromDB();
                    break;
                case 2:RoleLauncher.initializeDriver();
                    RoleLauncher.addNewRole("ROLE_SHOPPER","usual shopper");
                    break;
                case 3:RoleLauncher.initializeDriver();
                    RoleLauncher.deleteOneRole("ROLE_SHOPPER");
                    break;
                case 4:RoleLauncher.initializeDriver();
                    RoleLauncher.updateOneRole("usual shopper","shopper");
                    break;
            }

        scanner.close();
    }
    public static void initializeDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void readAllFromDB() {

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

//                String resultString = "id = " + idValueFromDB + ", name = " + nameValueFromDB+ ", description = "+descriptionValueFromDB;

//                System.out.println(resultString);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        roleList.forEach(System.out::println);

    }

    public static void addNewRole(String role,String description) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "INSERT INTO `lits_cv_java_2`.`role` (`"+ DB_COLUMN_NAME+"`, `"+DB_COLUMN_DESCRIPTION+"`) " +
                    "VALUES ('"+role+"', '"+description+"');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteOneRole(String role) {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "DELETE FROM `lits_cv_java_2`.`role` WHERE (`"+DB_COLUMN_NAME+"` = '"+role+"');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateOneRole(String oldDescription,String newDescription) {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "UPDATE `lits_cv_java_2`.`role` SET `description` = '"+ newDescription+"' " +
                    "WHERE (`"+DB_COLUMN_DESCRIPTION+"` = '"+oldDescription+"');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
