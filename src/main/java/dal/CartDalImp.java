package dal;

import dto.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDalImp implements CartDal {

    private static final Logger logger = LoggerFactory.getLogger(CartDalImp.class);

    private SessionFactory sessionFactory;

    @Override
    public List<Cart> readAllFromDB() {
       return null;
    }

    @Override
    public Optional<Cart> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean createCartInToDB(Cart cart) {
        return false;
    }

    @Override
    public boolean updateCart(int id, Cart cart) {
        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public List<Cart> readCartListByOrderId(Long orderId) {
        logger.info("going to create session");
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("going to read cart list");

        List<Cart> cartList = session.createQuery("from cart").list();
        return cartList;


    }
}

