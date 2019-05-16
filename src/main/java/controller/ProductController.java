package controller;
import dal.ProductDalImp;
import dto.Product;
import model.ProductListResponseModel;
import model.ProductModel;
import model.ProductResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
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
    public ProductResponseModel create(@RequestBody ProductResponseModel model) {

        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }
//delete - get, edit-post

}
