package dto;

import java.sql.*;

public class Role {
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_ID = "id";
    public static final String DB_COLUMN_NAME = "name";
    public static final String DB_COLUMN_DESCRIPTION = "description";

    private int id;
    private String name;
    private String description;

    public Role() {
    }

    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public static void readAllFromDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM role;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String idValueFromDB = resultSet.getString(DB_COLUMN_ID);
                String nameValueFromDB = resultSet.getString(DB_COLUMN_NAME);
                String descriptionValueFromDB = resultSet.getString(DB_COLUMN_DESCRIPTION);

                String resultString = "id = " + idValueFromDB + ", name = " + nameValueFromDB+ ", description = "+descriptionValueFromDB;

                System.out.println(resultString);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addNewRole(String role,String description) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
