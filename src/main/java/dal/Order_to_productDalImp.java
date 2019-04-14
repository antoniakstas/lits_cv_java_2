package dal;

import dto.Order_to_product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order_to_productDalImp implements Order_to_productDal {

    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    //public static final String DB_COLUMN_USER_ID = "id";
    public static final String DB_TABLE_ORDER_TO_PRODUCT = "order_to_product";
    public static final String DB_ID = "id";
    public static final String DB_ORDER_ID = "order_" + DB_ID;
    public static final String DB_PRODUCT_COUNT = "product_count";
    public static final String DB_PRICE_ID = "price_" + DB_ID;


    public Order_to_productDalImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order_to_product> readAllFromDB() {
        Connection connection = null;
        Statement statement = null;
        List<Order_to_product> order_to_productList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM order_to_productList";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_ID);
                Integer order_idValueFromDB = resultSet.getInt(DB_ORDER_ID);
                Integer product_countValueFromDB = resultSet.getInt(DB_PRODUCT_COUNT);
                Integer price_idValueFromDB = resultSet.getInt(DB_PRICE_ID);

                Order_to_product order_to_product = new Order_to_product(idValueFromDB, order_idValueFromDB, product_countValueFromDB, price_idValueFromDB);
                order_to_productList.add(order_to_product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  order_to_productList;
    }

    @Override
    public Optional<Order_to_product> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createOrder_to_productInToDB(Order_to_product order_to_product) {
        return false;
    }

    @Override
    public boolean updateOrder_to_product(int id, Order_to_product order_to_product) {
        return false;
    }

    @Override
    public boolean deleteOrder_to_product(int id) {
        return false;
    }
}

