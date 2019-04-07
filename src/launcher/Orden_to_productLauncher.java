package launcher;

import java.sql.*;

public class Order_to_productLauncher {

    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_USER_ID = "id";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();



               /* String insert_intoTableSQL = "INSERT INTO `lits_cv_java_2`.`Order_to_product` " +
                        "(`id`, `order_id`, `product_count`, `price_id`) VALUES ('11', '4', '6', '8')";
                statement.execute(insert_intoTableSQL);*/



               /* String updateTableSQL = "UPDATE `lits_cv_java_2`." +
                        "`Order_to_product` SET `order_id` = '1', " +
                        "`product_count` = '1', `price_id` = '1' WHERE (`id` = '3')";
                statement.execute(updateTableSQL);*/



               /*String deleteTableSQL = "DELETE FROM `lits_cv_java_2`.`Order_to_product` WHERE (`id` = '11')";
                statement.execute(deleteTableSQL);*/


            String sqlQuery = "SELECT id, order_id, product_count, price_id FROM Order_to_product";
            ResultSet resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_USER_ID);
                Integer order_idValueFromDB = resultSet.getInt("order_id");
                Integer product_countValueFromDB = resultSet.getInt("product_count");
                Integer price_idValueFromDB = resultSet.getInt("price_id");

                String resultString = "Next values were read fom the DB: id = " +
                        idValueFromDB + ", with order_id = " + order_idValueFromDB +
                        ", with product_count = " + product_countValueFromDB +
                        ", with price_id = " + price_idValueFromDB;


                System.out.println(resultString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
