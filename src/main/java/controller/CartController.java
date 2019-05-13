package controller;

import model.CartListResponseModel;
import model.CartResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
class CartController {
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
    public CartListResponseModel findItem(Integer id) {
        CartListResponseModel responseModel = new CartListResponseModel();

        return responseModel;
    }

    @PostMapping(path = "/item")
    public CartListResponseModel creat(@RequestBody CartResponseModel model) {
        CartListResponseModel responseModel = new CartListResponseModel();

        return responseModel;
    }


}

