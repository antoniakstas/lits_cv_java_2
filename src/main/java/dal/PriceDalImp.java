
package dal;

import dto.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class PriceDalImp implements PriceDal {
    private static final Logger logger = LoggerFactory.getLogger(PriceDalImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public List<Price> readAllFromDB() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Price> priceList = session.createQuery("from price").list();
        return priceList;
    }

    @Override
    public Optional<Price> readFromDBById(int id) {
        return Optional.empty();
    }


    @Override
    public Price createPriceInToDB(Price price) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(price);
        //   session.persist(price);
        logger.info("Price saved successfully, Price Details=" + price);
        return price;


    }

    @Override
    public boolean updatePrice1(int id, Price price) {
        return false;
    }

    @Override
    public boolean deletePrice(int id) {
        return false;
    }

    @Override
    @Transactional
    public Price updatePrice(Price price) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(price);
        logger.info("Price updated successfully, Price Details=" + price);
        return price;
    }

    @Override
    @Transactional

    public void deleteLine(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Price price = (Price) session.load(Price.class, new Long(id));
        if (null != price) {
            session.delete(price);
            logger.info("Price deleted successfully, Price Details=" + price);
        }

    }
    @Override
    public List<Price> readAllFromDBByProductId(Long productIdValue) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Price> priceList = (List<Price>) session
                .createQuery(
                        "select p from dto.Price p " +
                                "where p.productId = :abc")
                .setParameter("abc", productIdValue)
                .list();

        return priceList;
    }
    @Override
    public List<Price> readAllFromDBByPriceId(Long priceIdValue) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Price> priceList = (List<Price>) session
                .createQuery(
                        "select p from dto.Price p " +
                                "where p.priceId = :abc")
                .setParameter("abc", priceIdValue)
                .list();

        return priceList;
    }
}




