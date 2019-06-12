package service;

import dal.OrderDal;
import dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier(value = "orderDal")
    private OrderDal orderDal;


    @Override
    @Transactional
    public List<Order> findAllOrder() {
        List<Order> orderList = orderDal.readAllFromDB();
        return orderList;
    }

    @Override
    public Optional<Order> createOrderInToDB(Order order) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> updateOrderInToDB(Order order) {
        return Optional.empty();
    }

    @Override
    public void deleteOrder(String index) {

    }
}

