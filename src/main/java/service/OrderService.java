package service;

import dto.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public List<Order> findAllOrder();

    public Optional<Order> createOrderInToDB(Order order);

    public Optional<Order> updateOrderInToDB(Order order);

    public void deleteOrder(String index);
}
