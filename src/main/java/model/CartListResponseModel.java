package model;

import java.util.ArrayList;
import java.util.List;

public class CartListResponseModel {
    List<CartResponseModel> cartResponseModel = new ArrayList<>();

    public List<CartResponseModel> getCartResponseModel() {
        return cartResponseModel;
    }

    public void setCartResponseModel(List<CartResponseModel> cartResponseModel) {
        this.cartResponseModel = cartResponseModel;
    }
}
