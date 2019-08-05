package service;


import dal.CartDal;
import dto.Cart;
import model.CartResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CartServiceImpl implements CartService {


    @Autowired
    @Qualifier(value = "cartDal")
    private CartDal cartDal;

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





    @Override
    public List<Cart> findAllCarts() {
        List<Cart> cartList = cartDal.readAllFromDB();
        return cartList;
    }

    @Override
    @Transactional
    public Optional<Cart> createCart(Cart cart) {
        Integer cartId = cart.getId();
        boolean cartIdIsInDB = false;
        List<Cart> cartList = cartDal.readAllFromDB();
        for (Cart cart1 : cartList) {
            if (cartId == cart1.getId()) {
                cartIdIsInDB = true;
                break;
            }
        }

        if (!cartIdIsInDB) {
            return Optional.of(this.cartDal.createCart(cart));
        }
        return Optional.of(new Cart());
    }

    @Override
    @Transactional
    public Optional<Cart> updateCart(Cart cart) {

        this.cartDal.updateCart(cart);

        return Optional.of(this.cartDal.updateCart(cart));
    }

    @Override
    @Transactional
    public Optional<Cart> deleteLine(Integer id) {
        cartDal.deleteCart(id);

        return null;
    }
    @Override
    @Transactional
    public List<Cart> readFromDBById(Integer id) {
        List<Cart> cartList = cartDal.readFromDBById(id);
        return cartList;
    }

    @Override
    @Transactional
    public List<Cart> readFromDBByOrderId(Integer orderId){
        List<Cart> cartList = cartDal.readFromDBByOrderId(orderId);
        return cartList;
    }

    @Override
    @Transactional
    public Cart readByOrderIdAndPriceId(Integer orderId, Integer priceid){
        Cart cart = cartDal.readByOrderIdAndPriceId(orderId, priceid);
        return cart;
    }

}
