package model;

import java.util.ArrayList;
import java.util.List;

public class OrderModelWithCartItems {

List<CartModel> cartList = new ArrayList<>();

    public List<CartModel> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartModel> cartList) {
        this.cartList = cartList;
    }
}