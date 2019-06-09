package controller;


import model.CartListResponseModel;
import model.CartResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.CartService;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
class CartController {


    @Autowired
    private CartService cartService;

    @GetMapping(path = "/list")
    public CartListResponseModel findAll() {
        CartListResponseModel responseModel = new CartListResponseModel();

        CartResponseModel element1 = new CartResponseModel();
        CartResponseModel element2 = new CartResponseModel();
        List<CartResponseModel> cartResponseModel = new ArrayList<>();

        cartResponseModel.add(element1);
        cartResponseModel.add(element2);

        responseModel.setCartResponseModel(cartResponseModel);

        return responseModel;
    }


    @GetMapping(path = "/item")
    public CartListResponseModel findItem( Long order_id ) {
        CartListResponseModel responseModel = new CartListResponseModel();

        List<CartResponseModel> allCartByOrderId = cartService.findAllCartByOrderId(order_id);
        responseModel.setCartResponseModel(allCartByOrderId);


        return responseModel;
    }

    @PostMapping(path = "/item")
    public CartListResponseModel creat(@Valid @RequestBody CartResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        CartListResponseModel responseModel = new CartListResponseModel();


        return responseModel;
    }

    @GetMapping(path = "/delete")
    public CartResponseModel deleteItem(Integer id, Integer order_id, Integer product_count, Integer price_id ) {
        findAll();
        CartResponseModel responseModel = new CartResponseModel();

        findAll().getCartResponseModel().remove(id);
        findAll().getCartResponseModel().remove(order_id);
        findAll().getCartResponseModel().remove(product_count);
        findAll().getCartResponseModel().remove(price_id);
        return responseModel;
    }

//    @PostMapping(path = "/update")
//    public CartResponseModel update(@RequestBody Integer id, Integer order_id, Integer product_count, Integer price_id) {
//        CartResponseModel responseModel = new CartResponseModel();
//
//        return responseModel;
//    }


}

