package launcher;

import dto.Price;

import java.sql.*;

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

    public static void main(String[] args){
        Price price = new Price(11,12, 21,2,"active","4 days");


        selectTable();
        System.out.println("  ");
        createLineFromTable(price);
        selectTable();
        System.out.println("  ");
        UpdateFromTable();
        selectTable();
        System.out.println("  ");
        DeleteLineFromTable();
        selectTable();


    }
    public static void selectTable(){

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
            String selectTableSQL = "SELECT id, product_id, value, mult, active, deliverydays from price";

            ResultSet rs = statement.executeQuery(selectTableSQL);


            while (rs.next()) {
                String id = rs.getString(DB_COLUMN_PRICE_ID);
                String product_id = rs.getString(DB_COLUMN_PRICE_PRODUCT_ID);
                String value = rs.getString(DB_COLUMN_PRICE_VALUE);
                String mult = rs.getString(DB_COLUMN_PRICE_MULT);
                String active = rs.getString( DB_COLUMN_PRICE_ACTIVE);
                String deliverydays = rs.getString(DB_COLUMN_PRICE_DELIVERYDAYS);

                System.out.println("id product_id value mult active deliverydays");
                System.out.println(id + "  " + "    " + product_id + "   " + "     " + value + "     " + mult + "  " + "" + active + "   " + "   " + deliverydays);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void createLineFromTable(Price price) {
        try {
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            //         String insertTableSQL = INSERT INTO `lits_cv_java_2`.`price` (`product_id`, `value`, `mult`, `active`, `deliverydays`)
            //         VALUES ('2', '2', '3', 'active', '4 days');

            String insertTableSQL = "INSERT INTO price"
                    + "(id, product_id, value, mult, active, deliverydays ) " + "VALUES"
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

            String updateTableSQL = "UPDATE price SET deliverydays  = '9 days' WHERE "+DB_COLUMN_PRICE_ID+" = 11";

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


            String sqlQuery = "DELETE FROM `lits_cv_java_2`.`price` WHERE (`"+DB_COLUMN_PRICE_ID+"` = '11');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}









