package service;

        import dto.Cart;
        import model.CartResponseModel;

        import java.util.List;

public interface CartService {


    List<Cart> findAllCart();
    public List<CartResponseModel> findAllCartByOrderId(Long orderId);


}
