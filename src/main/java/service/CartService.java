package service;

        import dto.Cart;
        import model.CartResponseModel;

        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.Optional;

public interface CartService {

    public List<CartResponseModel> findAllCartByOrderId(Long orderId);




    List<Cart> findAllCarts();
    public Optional<Cart> createCart(Cart cart);
    public Optional<Cart> updateCart(Cart cart);
    public Optional<Cart> deleteLine(Long id);

}
