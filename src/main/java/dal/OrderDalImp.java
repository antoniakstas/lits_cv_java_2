//
//package dal;
//
//import dto.Order;
//import dto.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class OrderDalImp implements OrderDal {
//    private static final Logger logger = LoggerFactory.getLogger(OrderDalImp.class);
//
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sf) {
//        this.sessionFactory = sf;
//    }

//    @Override
//    @Transactional
//    public List<Order> readAllFromDB() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Order> orderList = session.createQuery("from orders").list();
//
//        return orderList;
//


//        Connection connection = null;
//        Statement statement = null;
//        List<Order> orderList = new ArrayList<>();
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            statement = connection.createStatement();
//
//            String sqlQuery = "SELECT * FROM lits_cv_java_2.`order`";
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//            while (resultSet.next()) {
//                    Integer id = resultSet.getInt(DB_COLUMN_ORDER_ID);
//                    String status = resultSet.getString(DB_COLUMN_ORDER_STATUS);
//                    Integer user_m_id = resultSet.getInt(DB_COLUMN_ORDER_USER_M_ID);
//                    Integer user_c_id = resultSet.getInt(DB_COLUMN_ORDER_USER_C_ID);
//
//                    Order order = new Order(id, status, user_m_id, user_c_id );
//                    orderList.add(order);
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//
//        @Override
//        public Optional<Order> readFromDBById(int id) {
//            return Optional.empty();
//        }
//
//
//        @Override
//        public boolean updateOrder(int id, Order order) {
//            return false;
//        }
//
//        @Override
//        public boolean deleteOrder(int id) {
//            return false;
//        }
//
//        @Override
//        public boolean createOrderInToDB(Order order) {
//            try {
//                Connection connection = null;
//                Statement statement = null;
//                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//                statement = connection.createStatement();
//                //         String insertTableSQL = INSERT INTO `lits_cv_java_2`.`price` (`product_id`, `value`, `mult`, `active`, `deliverydays`)
//                //         VALUES ('2', '2', '3', 'active', '4 days');
//
//                String insertTableSQL = "INSERT INTO order("+DB_COLUMN_ORDER_ID+", "+DB_COLUMN_ORDER_STATUS+", "+DB_COLUMN_ORDER_USER_M_ID+", "+DB_COLUMN_ORDER_USER_C_ID+" ) " + "VALUES"
//                        + "("+order.getId()+",'"+order.getStatus()+"','"+order.getUserMId()+"','"+order.getUserCId()+"' )";
//                statement.executeUpdate(insertTableSQL);
//
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }


//            return false;
//
//        }
//
//
//    }



//package dal;
//
//import dto.Order;
//
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//    public class OrderDalImp implements OrderDal {
//
//        public static final String DB_URL = "jdbc:mysql://localhost:3306/lits_cv_java_2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        public static final String DB_USER = "root";
//        public static final String DB_PASSWORD = "root";
//        public static final String DB_COLUMN_ORDER_ID = "id";
//        public static final String DB_COLUMN_ORDER_STATUS = "status";
//        public static final String DB_COLUMN_ORDER_USER_M_ID = "user_m_id";
//        public static final String DB_COLUMN_ORDER_USER_C_ID = "user_c_id";
//        public static final String DB_TABLE_ORDER_ORDER = "order";
//
//
//        public OrderDalImp() {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public List<Order> readAllFromDB() {
//            Connection connection = null;
//            Statement statement = null;
//            List<Order> orderList = new ArrayList<>();
//            try {
//                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//                statement = connection.createStatement();
//
//                String sqlQuery = "SELECT * FROM "+DB_TABLE_ORDER+"";
//                ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//                while (resultSet.next()) {
//                    Integer id = resultSet.getInt(DB_COLUMN_ORDER_ID);
//                    String status = resultSet.getString(DB_COLUMN_STATUS);
//                    Integer user_m_id = resultSet.getInt(DB_COLUMN_USER_M_ID);
//                    Integer user_c_id = resultSet.getInt(DB_COLUMN_USER_C_ID);
//
//                    Order order = new Order(id, status, user_m_id, user_c_id );
//                    orderList.add(order);
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            return orderList;
//        }
//
//        @Override
//        public Optional<Order> readFromDBById(int id) {
//            return Optional.empty();
//        }
//
//
//        @Override
//        public boolean updateOrder(int id, Order order) {
//            return false;
//        }
//
//        @Override
//        public boolean deleteOrder(int id) {
//            return false;
//        }
//
//        @Override
//        public boolean createOrderInToDB(Order order) {
//            try {
//                Connection connection = null;
//                Statement statement = null;
//                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//                statement = connection.createStatement();
//                //         String insertTableSQL = INSERT INTO `lits_cv_java_2`.`price` (`product_id`, `value`, `mult`, `active`, `deliverydays`)
//                //         VALUES ('2', '2', '3', 'active', '4 days');
//
//                String insertTableSQL = "INSERT INTO " + DB_TABLE_ORDER
//                        + "("+DB_COLUMN_ORDER_ID+", "+DB_COLUMN_STATUS+", "+DB_COLUMN_USER_M_ID+", "+DB_COLUMN_USER_C_ID+" ) " + "VALUES"
//                        + "("+order.getId()+",'"+order.getStatus()+"','"+order.getUserMId()+"','"+order.getUserCId()+"' )";
//                statement.executeUpdate(insertTableSQL);
//
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//
//
//            return false;
//
//        }
//
//
//    }
//
//
//

