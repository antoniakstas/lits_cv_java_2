package controller;

import dto.Product;
import io.swagger.annotations.Api;
import model.CartResponseModel;
import model.ProductResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Api(value = "Product Resource REST Endpoint", description = "Shows the product info")
public class ProductController {
    @Autowired

    private ProductService productService;

    @GetMapping(path = "/list")
    public List<Product> findAll() {

        List<Product> allProduct = productService.findAllProduct();
        return allProduct;
//        ProductListResponseModel responseModel = new ProductListResponseModel();
//        ProductResponseModel e1ement1 = new ProductResponseModel();
//        ProductResponseModel e1ement2 = new ProductResponseModel();
//        List<ProductResponseModel> productResponseModels = new ArrayList<>();
//        productResponseModels.add(e1ement1);
//        productResponseModels.add(e1ement2);
//        responseModel.setProductResponseModelList(productResponseModels);
//        return responseModel;
    }

    @GetMapping(path = "/item")
    public ProductResponseModel findItem(Integer id) {
        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }

    @PostMapping(path = "/item")
    public Product create(@ModelAttribute("product") Product product) {
//        bindingResult.hasErrors();
//        ProductResponseModel responseModel = new ProductResponseModel();
//
//        return responseModel;

        Optional<Product> productWasCreated = this.productService.createProductInToDB(product);

        if(productWasCreated.isPresent()){
            return productWasCreated.get();
        }
        return null;
    }

    //edit-post
    @GetMapping(path = "/delete")
    public ProductResponseModel deleteItem(Integer id) {
        findAll();
        ProductResponseModel responseModel = new ProductResponseModel();

        findAll().remove(id);
        return responseModel;
    }

    @PostMapping(path = "/update")
    public ProductResponseModel update(@RequestBody Integer id) {
        ProductResponseModel responseModel = new ProductResponseModel();

        return responseModel;
    }
}
