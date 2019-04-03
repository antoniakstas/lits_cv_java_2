package dto;

import java.sql.*;

public class Role {
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";

    private int id;
    private String name;
    private String discription;

    public Role() {
    }

    public Role(int id, String name, String discription) {
        this.id = id;
        this.name = name;
        this.discription = discription;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }


    public static void ReadAllFromDB() {

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
                String idValueFromDB = resultSet.getString("id");
                String nameValueFromDB = resultSet.getString("name");

                String resultString = "id = " + idValueFromDB + " name = " + nameValueFromDB;

                System.out.println(resultString);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
