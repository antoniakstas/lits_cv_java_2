package dal;

import dto.Price;
import dto.Product;
import dto.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ProductDalImp implements ProductDal {
    private static final Logger logger = LoggerFactory.getLogger(PriceDalImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public List<Product> readAllFromDB() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from product").list();
        return productList;
    }

    @Override
    public Optional<Product> readFromDBById(int id) {
        return Optional.empty();
    }


    @Override
    @Transactional
    public Product createProductInToDB(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        //   session.persist(price);
        logger.info("Product saved successfully, Product Details=" + product);
        return product;


    }

    @Override
    public Product updateProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product updated successfully, Product Details=" + product);
        return product;
    }
//    @Override
//    public boolean createProductInToDB(Product product) {
//        return false;
//    }


    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public void deleteLine(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.load(Product.class, id);
        if (product != null) {
            session.delete(product);
            logger.info("Product deleted successfully, Product Details=" + product);
        }

    }


}

