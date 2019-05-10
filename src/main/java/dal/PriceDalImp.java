
package dal;

import dto.Price;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceDalImp implements PriceDal {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/lits_cv_java_2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
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
    public boolean createPriceInToDB(Price price) {
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


        return false;

    }

    @Override
    public boolean updatePrice(int id, Price price) {
        return false;
    }

    @Override
    public boolean deletePrice(int id) {
        return false;
    }
}

