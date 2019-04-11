
package dal;

import dto.Price;
import dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceDalImp implements PriceDal {

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

    public PriceDalImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Price> readAllFromDB() {
        Connection connection = null;
        Statement statement = null;
        List<Price> priceList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM "+DB_TABLE_PRICE+"";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(DB_COLUMN_PRICE_ID);
                Integer product_id = resultSet.getInt(DB_COLUMN_PRICE_PRODUCT_ID);
                Integer value = resultSet.getInt(DB_COLUMN_PRICE_VALUE);
                Integer mult = resultSet.getInt(DB_COLUMN_PRICE_MULT);
                String active = resultSet.getString( DB_COLUMN_PRICE_ACTIVE);
                String deliverydays = resultSet.getString(DB_COLUMN_PRICE_DELIVERYDAYS);

                Price price = new Price(id, product_id, value, mult, active, deliverydays );
                priceList.add(price);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return priceList;
    }

    @Override
    public Optional<Price> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createPriceInToDB(User user) {
        return false;
    }

    @Override
    public boolean updatePrice(int id, User user) {
        return false;
    }

    @Override
    public boolean deletePrice(int id) {
        return false;
    }
}

