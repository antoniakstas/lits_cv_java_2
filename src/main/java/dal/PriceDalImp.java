
package dal;

import dto.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceDalImp implements PriceDal {

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
    public boolean createPriceInToDB(Price price) {
        return false;
    }

    @Override
    public boolean updatePrice(int id, Price price) {
        return false;
    }

    @Override
    public boolean deletePrice(int id) {
        return false;
    }

}






