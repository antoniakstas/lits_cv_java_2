package service;

import dal.ProductDal;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier(value = "productDal")
    private ProductDal productDal;


    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = productDal.readAllFromDB();
        return productList;
    }
}
