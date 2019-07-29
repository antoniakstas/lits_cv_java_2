package service;

import dto.Order;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    public List<Order> findAllOrder();

    public Optional<Order> createOrderInToDB(Order order);

    public Optional<Order> updateOrderInToDB(Order order);
    public void updateOrderStatus(Integer orderId);

    public void deleteOrder(String index);

    public List<Order> findOrderById(Integer id);

    public List<Order> findOrderByUserCId(Integer userCId, String status);

}
