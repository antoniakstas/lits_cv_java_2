package dal;

import dto.Product;
import dto.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDalImp implements ProductDal {

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
    public boolean createProductInToDB(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(int id) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

}

