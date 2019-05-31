package service;


import dal.CartDal;


import dto.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
