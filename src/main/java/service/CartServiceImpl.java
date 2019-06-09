package service;


import dal.CartDal;
import dto.Cart;
import model.CartResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class CartServiceImpl implements CartService {


    @Autowired
    @Qualifier(value = "cartDal")
    private CartDal cartDal;


    @Override
    public List<Cart> findAllCart() {
        List<Cart> cartList = cartDal.readAllFromDB();
        return cartList;

    }

    public List<CartResponseModel> findAllCartByOrderId(Long orderId) {
        List<Cart> carts = cartDal.readCartListByOrderId(orderId);
        List<CartResponseModel> cartListByOrderId = new ArrayList<>(carts.size());

        for (Cart cartItem : carts) {
            CartResponseModel item = new CartResponseModel();
            item.setOrder_id(cartItem.getOrder_id());
            item.setProduct_count(cartItem.getProduct_count());
            item.setPrice_id(cartItem.getPrice_id());
            cartListByOrderId.add(item);

        }


        return cartListByOrderId;

    }

}
