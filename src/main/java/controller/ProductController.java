package controller;

import dal.ProductDalImp;
import dto.Product;
import io.swagger.annotations.Api;
import model.ProductListResponseModel;
import model.ProductModel;
import model.ProductResponseModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
@Api(value = "Product Resource REST Endpoint", description = "Shows the product info")
public class ProductController {
    @GetMapping(path = "/list")
    public ProductListResponseModel findAll() {

        ProductListResponseModel responseModel = new ProductListResponseModel();
        ProductResponseModel e1ement1 = new ProductResponseModel();
        ProductResponseModel e1ement2 = new ProductResponseModel();
        List<ProductResponseModel> productResponseModels = new ArrayList<>();
        productResponseModels.add(e1ement1);
        productResponseModels.add(e1ement2);
        responseModel.setProductResponseModelList(productResponseModels);
        return responseModel;
    }

    @GetMapping(path = "/item")
    public ProductResponseModel findItem(Integer id) {
        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }

    @PostMapping(path = "/item")
    public ProductResponseModel create(@Valid @RequestBody ProductResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }

    //edit-post
    @GetMapping(path = "/delete")
    public ProductResponseModel deleteItem(Integer id) {
        findAll();
        ProductResponseModel responseModel = new ProductResponseModel();

        findAll().getProductResponseModelList().remove(id);
        return responseModel;
    }

    @PostMapping(path = "/update")
    public ProductResponseModel update(@RequestBody Integer id) {
        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }
}
