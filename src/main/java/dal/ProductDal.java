package dal;

import dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDal {

    List<Product> readAllFromDB();

    Optional<Product> readFromDBById(int id);

    public Product createProductInToDB(Product product);

    public Product updateProduct(Product product);

    boolean deleteProduct(int id);

    public void deleteLine(Long id);
}
