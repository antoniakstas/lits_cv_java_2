package dal;

import dto.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CartDalImp implements CartDal {

    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";
    public static final String DB_TABLE_CART = "cart";
    public static final String DB_ID = "id";
    public static final String DB_ORDER_ID = "order_" + DB_ID;
    public static final String DB_PRODUCT_COUNT = "product_count";
    public static final String DB_PRICE_ID = "price_" + DB_ID;


    public CartDalImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> readAllFromDB() {
        Connection connection = null;
        Statement statement = null;
        List<Cart> cartList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Input a number: ");
            int num = 1;
            if (num==1){
                String insert_intoTableSQL = "INSERT INTO `lits_cv_java_2`.`" +
                        DB_TABLE_CART + "` " + "(`" +
                        DB_ID + "`, `" +
                        DB_ORDER_ID + "`, `" +
                        DB_PRODUCT_COUNT + "`, `" +
                        DB_PRICE_ID + "`) " +
                        "VALUES ('11', '4', '6', '8')";
                statement.execute(insert_intoTableSQL);
            }
            if (num==2){
                String updateTableSQL = "UPDATE `lits_cv_java_2`." + "`" +
                        DB_TABLE_CART + "` " + "" +
                        "SET `" +
                        DB_ORDER_ID + "` = '6', " + "`" +
                        DB_PRODUCT_COUNT + "` = '5', `" +
                        DB_PRICE_ID + "` = '6' " +
                        "WHERE (`" + DB_ID + "` = '3')";
                statement.execute(updateTableSQL);
            }
            if (num==3){
                String deleteTableSQL = "DELETE FROM `lits_cv_java_2`.`" +
                        DB_TABLE_CART + "` " +
                        "WHERE (`" + DB_ID + "` = '11')";
                statement.execute(deleteTableSQL);
            }
//            scanner.close();
            String sqlQuery =
                    "SELECT " +
                            DB_ID + ", " +
                            DB_ORDER_ID + ", " +
                            DB_PRODUCT_COUNT + ", " +
                            DB_PRICE_ID +
                            " FROM " + DB_TABLE_CART;
            ResultSet resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                Integer idValueFromDB = resultSet.getInt(DB_ID);
                Integer order_idValueFromDB = resultSet.getInt(DB_ORDER_ID);
                Integer product_countValueFromDB = resultSet.getInt(DB_PRODUCT_COUNT);
                Integer price_idValueFromDB = resultSet.getInt(DB_PRICE_ID);

                Cart cart = new Cart(
                        idValueFromDB,
                        order_idValueFromDB,
                        product_countValueFromDB,
                        price_idValueFromDB);
                cartList.add(cart);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

    @Override
    public Optional<Cart> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createCartInToDB(Cart cart) {
        return false;
    }

    @Override
    public boolean updateCart(int id, Cart cart) {
        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }
}

