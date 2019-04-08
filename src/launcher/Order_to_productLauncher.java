package launcher;
import java.sql.*;
import java.util.Scanner;

public class Order_to_productLauncher {
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_USER_ID = "id";
    public static final String DB_TABLE_ORDER_TO_PRODUCT = "order_to_product";
    public static final String DB_ID = "id";
    public static final String DB_ORDER_ID = "order_" + DB_ID;
    public static final String DB_PRODUCT_COUNT = "product_count";
    public static final String DB_PRICE_ID = "price_" + DB_ID;


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


            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a number: ");
            int num = scanner.nextInt();
            if (num==1){
                String insert_intoTableSQL = "INSERT INTO `lits_cv_java_2`.`" + DB_TABLE_ORDER_TO_PRODUCT + "` " +
                        "(`" + DB_ID + "`, `" + DB_ORDER_ID + "`, `" + DB_PRODUCT_COUNT + "`, `" + DB_PRICE_ID + "`) VALUES ('11', '4', '6', '8')";
                statement.execute(insert_intoTableSQL);
            }
            if (num==2){
                String updateTableSQL = "UPDATE `lits_cv_java_2`." +
                        "`" + DB_TABLE_ORDER_TO_PRODUCT + "` SET `" + DB_ORDER_ID + "` = '6', " +
                        "`" + DB_PRODUCT_COUNT + "` = '6', `" + DB_PRICE_ID + "` = '6' WHERE (`" + DB_ID + "` = '3')";
                statement.execute(updateTableSQL);
            }
            if (num==3){
                String deleteTableSQL = "DELETE FROM `lits_cv_java_2`.`" + DB_TABLE_ORDER_TO_PRODUCT + "` WHERE (`" + DB_ID + "` = '11')";
                statement.execute(deleteTableSQL);
            }
            scanner.close();
            String sqlQuery = "SELECT " + DB_ID + ", " + DB_ORDER_ID + ", " + DB_PRODUCT_COUNT + ", " + DB_PRICE_ID + " FROM " + DB_TABLE_ORDER_TO_PRODUCT;
            ResultSet resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_USER_ID);
                Integer order_idValueFromDB = resultSet.getInt(DB_ORDER_ID);
                Integer product_countValueFromDB = resultSet.getInt(DB_PRODUCT_COUNT);
                Integer price_idValueFromDB = resultSet.getInt(DB_PRICE_ID);

                String resultString = "Next values were read fom the DB: " + DB_ID + " = " +
                        idValueFromDB + ", with " + DB_ORDER_ID + " = " + order_idValueFromDB +
                        ", with " + DB_PRODUCT_COUNT + " = " + product_countValueFromDB +
                        ", with " + DB_PRICE_ID + " = " + price_idValueFromDB;


                System.out.println(resultString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
