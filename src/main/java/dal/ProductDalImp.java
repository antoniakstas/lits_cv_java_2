package dal;

import dto.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDalImp implements ProductDal {

//    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
//
//    public static final String DB_USER = "java_2_user";
//    public static final String DB_PASSWORD = "java_2_password";

    public static final String DB_URL = "jdbc:mysql://localhost:3306/lits_cv_java_2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
    public static final String DB_COLUMN_PRODUCT_ID = "id";
    public static final String DB_COLUMN_PRODUCT_INDEX = "index";
    public static final String DB_COLUMN_PRODUCT_NAME = "name";
    public static final String DB_COLUMN_PRODUCT_MANUFACTURER = "manufacturer";
    public static final String DB_COLUMN_PRODUCT_COUNT = "count";
    public static final String DB_TABLE_PRODUCT = "product";


    public ProductDalImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> readAllFromDB() {
        List<Product> productList = new ArrayList<>();
        productList.forEach(System.out::println);

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT " + DB_COLUMN_PRODUCT_ID + ", `" + DB_COLUMN_PRODUCT_INDEX + "`, " + DB_COLUMN_PRODUCT_NAME + "," +
                    "" + DB_COLUMN_PRODUCT_MANUFACTURER + ", " + DB_COLUMN_PRODUCT_COUNT + " FROM " + DB_TABLE_PRODUCT + "";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_ID);
                String indexValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_INDEX);
                String nameValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_NAME);
                String manufacturerValueFromDB = resultSet.getString(DB_COLUMN_PRODUCT_MANUFACTURER);
                Integer countValueFromDB = resultSet.getInt(DB_COLUMN_PRODUCT_COUNT);

                Product productFromDB = new Product(idValueFromDB, indexValueFromDB, nameValueFromDB, manufacturerValueFromDB, countValueFromDB);
                productList.add(productFromDB);

//                String resultString = "Next values from the DB: id = " +
//                        idValueFromDB + ", index = " + indexValueFromDB + ", name = " + nameValueFromDB +
//                        ", manufacturer = " + manufacturerValueFromDB
//                        + ", count = " + countValueFromDB;
//                System.out.println(resultString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        productList.forEach(System.out::println);

        return productList;
    }

    @Override
    public Optional<Product> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createProductInToDB(Product productToInsert) {
        try {
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
//        String insertTableSQL = "INSERT INTO Product"
//                        + "(id,`index`, name, manufacturer , count ) " + "VALUES"
//                        + "(13,'03455555','pomp water','dolzz', 2)";
            String insertTableSQL = "INSERT INTO " + DB_TABLE_PRODUCT + ""
                    + "(id,`index`, name, manufacturer , count ) " + "VALUES"
                    + "(" + productToInsert.getId() + ",'" + productToInsert.getIndex() + "','" + productToInsert.getName() + "','" + productToInsert.getManufacturer() + "', " + productToInsert.getCount() + ")";
            statement.executeUpdate(insertTableSQL);
            System.out.println("Insert id with number 13");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateProduct(int idValueToUpdate) {
        try {
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String updateTableSQL = "UPDATE " + DB_TABLE_PRODUCT + " SET manufacturer  = 'HEPU' WHERE " + DB_COLUMN_PRODUCT_ID + " = " + idValueToUpdate + "";
            statement.executeUpdate(updateTableSQL);
            System.out.println("Update id with number 13: dolzz = HEPU");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int idValueToUpdate) {

        try {
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String sqlQuery = "DELETE FROM `lits_cv_java_2`.`" + DB_TABLE_PRODUCT + "` WHERE (`" + DB_COLUMN_PRODUCT_ID + "` = '" + idValueToUpdate + "');\n";
            statement.executeUpdate(sqlQuery);
            System.out.println("Delete id with number 13");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
