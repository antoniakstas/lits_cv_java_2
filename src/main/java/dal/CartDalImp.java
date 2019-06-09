package dal;

import dto.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public class CartDalImp implements CartDal {

    private static final Logger logger = LoggerFactory.getLogger(CartDalImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public List<Cart> readAllFromDB() {
       // SELECT * FROM lits_cv_java_2.cart;
        return null;
    }

    @Override
    @Transactional
    public Optional<Cart> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public boolean createCartInToDB(Cart cart) {
        return false;
    }

    @Override
    @Transactional
    public boolean updateCart(int id, Cart cart) {
//        INSERT INTO `lits_cv_java_2`.`cart` (`id`,
//            `order_id`,
//            `product_count`,
//            `price_id`)
//        VALUES ('12', '3', '4', '4');
        return false;
    }

    @Override
    @Transactional
    public boolean deleteCart(int id ) {
        //DELETE FROM `lits_cv_java_2`.`cart` WHERE (`id` = '11');
        return false;
    }

    @Override
    @Transactional
    public List<Cart> readCartListByOrderId(Long orderId) {
        logger.info("going to create session");
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("going to read cart list");
        // TODO: add orderId to filter session.createQuery

        List<Cart> cartList = session.createQuery("from cart").list();
       // SELECT * FROM lits_cv_java_2.cart;
        return cartList;

    }
}


