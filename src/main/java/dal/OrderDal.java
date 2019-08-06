package dal;

import dto.Order;
import java.util.List;

public interface OrderDal {

        List<Order> readAllFromDB();

        List<Order> readFromDBById(Integer id);

        public Order createOrderInToDB(Order order);

        boolean updateOrder(int id, Order order);

        boolean deleteOrder(int id);
        public void deleteOrder(Integer id);

        public List<Order> findOrderByUserCId (Integer userCId, String status);

        public void updateOrderStatus(Integer orderId);
        public void updateOrderStatusFromManager(Integer orderId);


        }
