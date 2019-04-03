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
    selectData();
//
//    Product productToInsert = new Product();
//    insertData(productToInsert);
//    selectData();
//
//    int idValueToUpdate = 11;
//    updateData(idValueToUpdate);
//    selectData();
//
//    deleteData(idValueToUpdate);
//    selectData();
//


}

    public static void initializeDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void selectData(){


        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT "+DB_COLUMN_PRODUCT_ID+", name FROM user";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_ID);
                String indexValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_INDEX);
                String nameValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_NAME);
                String manufacturerValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_MANUFACTURER);
                Integer countValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_COUNT);

                Product productFromDB = new Product(idValueFromDB, indexValueFromDB, nameValueFromDB, manufacturerValueFromDB, countValueFromDB);

                productList.add(productFromDB);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Product productItem:productList) {
            System.out.println(productItem.toString());
        }
    }
}
