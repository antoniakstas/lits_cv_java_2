package launcher;

import dto.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductLauncher {

    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_COLUMN_PRODUCT_ID = "id";
    public static final String DB_COLUMN_PRODUCT_INDEX = "index";
    public static final String DB_COLUMN_PRODUCT_NAME = "name";
    public static final String DB_COLUMN_PRODUCT_MANUFACTURER = "manufacturer";
    public static final String DB_COLUMN_PRODUCT_COUNT = "count";


public static void main(String[] args){
    initializeDriver();
    selectProduct();

//    Product productToInsert = new Product("fff", "gg", 3);
    insertProduct();
    selectProduct();

    int idValueToUpdate = 13;
    updateProduct(idValueToUpdate);
    selectProduct();

    deleteProduct(idValueToUpdate);
    selectProduct();


}

    private static void deleteProduct(int idValueToUpdate) {

        try {

            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "DELETE FROM `lits_cv_java_2`.`Product` WHERE (`"+DB_COLUMN_PRODUCT_ID+"` = '13');\n";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static void updateProduct(int idValueToUpdate) {

        try {

            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String updateTableSQL = "UPDATE Product SET manufacturer  = 'HEPU' WHERE "+DB_COLUMN_PRODUCT_ID+" = 13";

            statement.executeUpdate(updateTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    private static void insertProduct() {

    try {
        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        statement = connection.createStatement();

        String insertTableSQL = "INSERT INTO Product"
                        + "(id,`index`, name, manufacturer , count ) " + "VALUES"
                        + "(13,'03455555','pomp water','dolzz', 2)";
                        statement.executeUpdate(insertTableSQL);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }


        }


    public static void initializeDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void selectProduct() {


        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT "+DB_COLUMN_PRODUCT_ID+", `"+DB_COLUMN_PRODUCT_INDEX+"`, "+DB_COLUMN_PRODUCT_NAME+"," +
                    ""+DB_COLUMN_PRODUCT_MANUFACTURER+", "+DB_COLUMN_PRODUCT_COUNT+" FROM Product";
//            String sqlQuery = "SELECT  id,  `index`,   name,   manufacturer, count FROM Product";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_ID);
                String indexValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_INDEX);
                String nameValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_NAME);
                String manufacturerValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_MANUFACTURER);
                Integer countValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_COUNT);

                Product productFromDB = new Product(idValueFromDB, indexValueFromDB, nameValueFromDB, manufacturerValueFromDB, countValueFromDB);

                productList.add(productFromDB);

                String resultString = "Next values from the DB: id = " +
                        idValueFromDB + ", index = " + indexValueFromDB + ", name = " + nameValueFromDB +
                        ", manufacturer = " + manufacturerValueFromDB
                        + ", count = " + countValueFromDB;

                System.out.println(resultString);


//                for (Product productItem:
//                        productList) {
//                    System.out.println(productItem.toString());
//                }
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }











}



