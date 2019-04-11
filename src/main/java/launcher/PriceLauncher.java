package launcher;



import dto.Price;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PriceLauncher {
    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_PRICE_ID = "id";
    public static final String DB_COLUMN_PRICE_PRODUCT_ID = "product_id";
    public static final String DB_COLUMN_PRICE_VALUE = "value";
    public static final String DB_COLUMN_PRICE_MULT = "mult";
    public static final String DB_COLUMN_PRICE_ACTIVE = "active";
    public static final String DB_COLUMN_PRICE_DELIVERYDAYS = "deliverydays";
    public static final String DB_TABLE_PRICE = "price";
    public static final String DB_NUM_DELETE = "11";
    public static void main(String[] args){
        Price price = new Price(11,12, 21,2,"active","4 days");

        System.out.println("Select table");
        selectTable();
        System.out.println(" createLineFromTable ");
        createLineFromTable(price);
        selectTable();
        System.out.println(" UpdateFromTable ");
        UpdateFromTable();
        selectTable();
        System.out.println(" DeleteLineFromTable ");
        DeleteLineFromTable();
        selectTable();


    }
    public static void selectTable(){

        List<Price> priceList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String selectTableSQL = "SELECT "+DB_COLUMN_PRICE_ID+","+DB_COLUMN_PRICE_PRODUCT_ID+", "+DB_COLUMN_PRICE_VALUE+", "+DB_COLUMN_PRICE_MULT+", "+DB_COLUMN_PRICE_ACTIVE+", "+DB_COLUMN_PRICE_DELIVERYDAYS+" from " + DB_TABLE_PRICE;

            ResultSet rs = statement.executeQuery(selectTableSQL);


            while (rs.next()) {

                Integer id = rs.getInt(DB_COLUMN_PRICE_ID);
                Integer product_id = rs.getInt(DB_COLUMN_PRICE_PRODUCT_ID);
                Integer value = rs.getInt(DB_COLUMN_PRICE_VALUE);
                Integer mult = rs.getInt(DB_COLUMN_PRICE_MULT);
                String active = rs.getString( DB_COLUMN_PRICE_ACTIVE);
                String deliverydays = rs.getString(DB_COLUMN_PRICE_DELIVERYDAYS);

                Price priceFromDB = new Price(id, product_id,value, mult, active, deliverydays);
                priceList.add(priceFromDB);


//                System.out.println("id product_id value mult active deliverydays");
//         System.out.println(id + "  " + "    " + product_id + "   " + "     " + value + "     " + mult + "  " + "" + active + "   " + "   " + deliverydays);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        priceList.forEach(System.out::println);

    }
    private static void createLineFromTable(Price price) {
        try {
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            //         String insertTableSQL = INSERT INTO `lits_cv_java_2`.`price` (`product_id`, `value`, `mult`, `active`, `deliverydays`)
            //         VALUES ('2', '2', '3', 'active', '4 days');

            String insertTableSQL = "INSERT INTO " + DB_TABLE_PRICE
                    + "("+DB_COLUMN_PRICE_ID+", "+DB_COLUMN_PRICE_PRODUCT_ID+", "+DB_COLUMN_PRICE_VALUE+", "+DB_COLUMN_PRICE_MULT+", "+DB_COLUMN_PRICE_ACTIVE+", "+DB_COLUMN_PRICE_DELIVERYDAYS+" ) " + "VALUES"
                    + "("+price.getId()+",'"+price.getProdukt_id()+"','"+price.getValue()+"','"+price.getMult()+"', '"+price.getActive()+"', '"+price.getDeliverydays()+"' )";
            statement.executeUpdate(insertTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public static void UpdateFromTable(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            //UPDATE `lits_cv_java_2`.`price` SET `deliverydays` = '9 days' WHERE (`id` = '11');

            String updateTableSQL = "UPDATE " + DB_TABLE_PRICE + " SET "+DB_COLUMN_PRICE_DELIVERYDAYS+"  = '9 days' WHERE " +DB_COLUMN_PRICE_ID+" = "+DB_NUM_DELETE+"";

            statement.executeUpdate(updateTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
    public static void DeleteLineFromTable(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            //DELETE FROM `lits_cv_java_2`.`price` WHERE (`id` = '11');


            String sqlQuery = "DELETE FROM `lits_cv_java_2`.`" + DB_TABLE_PRICE + "` WHERE (`" +DB_COLUMN_PRICE_ID+"` = '11');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}









