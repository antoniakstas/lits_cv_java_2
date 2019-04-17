package dal;

import dto.Cart;

import java.util.List;
import java.util.Optional;

public interface CartDal {
    List<Cart> readAllFromDB();

    Optional<Cart> readFromDBById(int id);

    boolean createCartInToDB(Cart cart);

    boolean updateCart(int id, Cart cart);

    boolean deleteCart(int id);


}
