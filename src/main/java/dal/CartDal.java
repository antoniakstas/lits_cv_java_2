package dal;

import dto.Cart;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CartDal {
    List<Cart> readCartListByOrderId(Long orderId);


    List<Cart> readAllFromDB();

    Optional<Cart> readFromDBById(int id);

    public Cart createCart(Cart cart);

    public Cart updateCart(Cart cart);
    public void deleteCart(Integer id);
    public List<Cart> readFromDBById(Integer id);
    public List<Cart> readFromDBByOrderId(Integer orderId);
    public Cart readByOrderIdAndPriceId(Integer orderId, Integer priceid);
    }


