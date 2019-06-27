package dal;

import dto.Order;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

public interface OrderDal {

        List<Order> readAllFromDB();

        List<Order> readFromDBById(Integer id);

        boolean createOrderInToDB(Order order);

        boolean updateOrder(int id, Order order);

        boolean deleteOrder(int id);

    }
