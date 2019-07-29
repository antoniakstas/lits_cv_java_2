
package dal;

import dto.Order;
import dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDalImp implements OrderDal {
    private static final Logger logger = LoggerFactory.getLogger(OrderDalImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public List<Order> readAllFromDB() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("from orders").list();

        return orderList;

    }

    @Override
    @Transactional
    public List<Order> readFromDBById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> orderList = (List<Order>) session
                .createQuery("select o from dto.Order o " +
                        "where o.id = :abc")
                .setParameter("abc", id)
                .list();

        return orderList;
    }


    @Override
    public boolean updateOrder(int id, Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        return false;
    }

    @Override
    @Transactional
    public List<Order> findOrderByUserCId(Integer userCId, String status) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> orderList = (List<Order>) session
                .createQuery("select o from dto.Order o " +
                        "where o.userCId = :abc " +
                        "and o.status = :asd")
                .setParameter("abc", userCId)
                .setParameter("asd", status)
                .list();
        return orderList;
    }

    @Override
    @Transactional
    public Order createOrderInToDB(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(order);

        logger.info("Order saved successfully, Order Details=" + order);
        return order;


    }


    @Override
    @Transactional
    public void updateOrderStatus(Integer orderId){
        String status = "confirm";
        Session session = this.sessionFactory.getCurrentSession();

        Order order = (Order) session
                .createQuery(
                        "select o from dto.Order o " +
                                "where o.id = :abc")
                .setParameter("abc", orderId)
                .uniqueResult();
        order.setStatus(status);
        session.update(order);
//        Session session = this.sessionFactory.getCurrentSession();
//        session
//                .createQuery("update o from dto.Order o set o.status = :bcm " +
//                        "where o.id = :abc")
//                .setParameter("abc", orderId)
//                .setParameter("bcm", status);
//        session.update(status);
//        int result = session.executeUpdate();
//        UPDATE `lits_cv_java_2`.`orders` SET `status` = 'confirm' WHERE (`id` = '10');

        logger.info("Order updated successfully, Order Details=" + orderId);
    }

}


