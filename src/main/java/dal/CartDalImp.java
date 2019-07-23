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
    public List<Cart> readCartListByOrderId(Long orderId) {
        logger.info("going to create session");
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("going to read cart list");
        // TODO: add orderId to filter session.createQuery

        List<Cart> cartList = session.createQuery("from cart").list();

        return cartList;

    }






    @Override
    @Transactional
    public List<Cart> readAllFromDB() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cart> cartList = session.createQuery("from cart").list();
        return cartList;
    }

    @Override
    public Optional<Cart> readFromDBById(int id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public List<Cart> readFromDBById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cart> cartList = (List<Cart>) session
                .createQuery("from dto.Cart c " +
                        "where c.id = :abc")
                .setParameter("abc",id)
                .list();

        return cartList;
    }
    @Override
    @Transactional
    public List<Cart> readFromDBByOrderId(Integer orderId){
        Session session = this.sessionFactory.getCurrentSession();
        List<Cart> cartList = (List<Cart>) session
                .createQuery("from dto.Cart c " +
                        "where c.order_id = :abc")
                .setParameter("abc",orderId)
                .list();

        return cartList;
    }

    @Override
    @Transactional
    public Cart createCart(Cart cart) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(cart);
        logger.info("Cart saved successfully, Cart Details = " + cart);
        return cart;
    }

    @Override
    @Transactional
    public Cart updateCart(Cart cart) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cart);
        logger.info("Cart updated successfully, Cart Details=" + cart);
        return cart;
    }

    @Override
    @Transactional
    public void deleteCart(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.load(Cart.class, Long.valueOf(id));
        if (cart != null) {
            session.delete(cart);
            logger.info("Cart deleted successfully, Cart Details=" + cart);
        }
    }

}


