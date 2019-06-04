package service;

import dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProduct();

    public Optional<Product> createProductInToDB(Product product);


}
