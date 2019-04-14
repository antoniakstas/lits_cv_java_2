package dal;

import dto.Order_to_product;

import java.util.List;
import java.util.Optional;

public interface Order_to_productDal {
    List<Order_to_product> readAllFromDB();

    Optional<Order_to_product> readFromDBById(int id);

    boolean createOrder_to_productInToDB(Order_to_product order_to_product);

    boolean updateOrder_to_product(int id, Order_to_product order_to_product);

    boolean deleteOrder_to_product(int id);


}
