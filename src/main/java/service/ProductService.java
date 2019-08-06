package service;

import dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAllProduct();

    public Optional<Product> createProductInToDB(Product product);

    public Optional<Product> updateProductInToDB(Product product);

    public void deleteProduct(Long id);
    public Product findById(Long id);
}
