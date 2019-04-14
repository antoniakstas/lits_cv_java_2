package dal;

import dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDal {

    List<Product> readAllFromDB();

    Optional<Product> readFromDBById(int id);

    boolean createProductInToDB(Product product);

    boolean updateProduct(int id);

    boolean deleteProduct(int id);
}
