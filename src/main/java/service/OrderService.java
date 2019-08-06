package service;

import dto.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public List<Order> findAllOrder();

    public Optional<Order> createOrderInToDB(Order order);

    public Optional<Order> updateOrderInToDB(Order order);
    public void updateOrderStatus(Integer orderId);

    public void deleteOrder(String index);
    public Optional<Order> deleteLine(Integer id);

    public List<Order> findOrderById(Integer id);

    public List<Order> findOrderByUserCId(Integer userCId, String status);
    public void updateOrderStatusFromManager(Integer orderId);

}
