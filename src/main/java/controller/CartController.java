package controller;


import dto.Cart;
import model.CartListResponseModel;
import model.CartResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.CartService;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
class CartController {


    @Autowired
    private CartService cartService;


    @GetMapping(path = "/read")
    public CartListResponseModel findItem( Long order_id ) {
        CartListResponseModel responseModel = new CartListResponseModel();

        List<CartResponseModel> allCartByOrderId = cartService.findAllCartByOrderId(order_id);
        responseModel.setCartResponseModel(allCartByOrderId);


        return responseModel;
    }



    @GetMapping(path = "/list")
    public List<Cart> findAll() {
        List<Cart> allCarts = cartService.findAllCarts();
        return allCarts;

    }

    @PostMapping(value = "/add")
    public Cart createCart(@ModelAttribute("cart") Cart cart) {

        Optional<Cart> cartWasCreated = this.cartService.createCart(cart);


        if (cartWasCreated.isPresent()) {
            return cartWasCreated.get();

        }

        return null;
    }

    @PostMapping(value = "/update")
    public Cart updateCart(@ModelAttribute("cart") Cart cart){

        Optional<Cart> cartWasUpdated = this.cartService.updateCart(cart);

        if (cartWasUpdated.isPresent()){
            return cartWasUpdated.get();
        }

        return null;
    }

    @GetMapping(value = "/delete")
    public void deleteLine(Long id){

        Optional<Cart> optionalCart = this.cartService.deleteLine(id);

    }

}

