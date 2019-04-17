package launcher;

import dal.CartDalImp;
import dto.Cart;

import java.util.List;

public class CartLauncher {

    public static void main(String[] args) {

        CartDalImp cartDalImp = new CartDalImp();

        List<Cart> cartList = cartDalImp.readAllFromDB();

        cartList.stream().forEach(x -> System.out.println(x));

    }
}
