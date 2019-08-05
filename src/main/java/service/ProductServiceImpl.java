package service;

import dal.ProductDal;
import dto.Price;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier(value = "productDal")
    private ProductDal productDal;


    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = productDal.readAllFromDB();
        return productList;
    }

    @Override
    @Transactional
    public Optional<Product> createProductInToDB(Product product) {


           Optional.of(this.productDal.createProductInToDB(product));

        return Optional.of(new Product());

    }

    @Override
    @Transactional
    public Optional<Product> updateProductInToDB(Product product) {

        return Optional.of(this.productDal.updateProduct(product));
    }

    @Override
    @Transactional
    public void deletePtoduct(Long id) {productDal.deleteLine(id);

    }
    @Override
    @Transactional
    public Product findById(Long id){
        Product productId = productDal.findById(id);
        return productId;
    }



}


