package controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import dto.Product;
import io.swagger.annotations.Api;
import model.CartResponseModel;
import model.CreateNewProductResponse;
import model.ProductResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Api(value = "Product Resource REST Endpoint", description = "Shows the product info")
public class ProductController {
    @Autowired
    private MessageSource messageSource;

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
    public CreateNewProductResponse create(Locale locale, @Valid @RequestBody ProductResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        ProductResponseModel responseModel = new ProductResponseModel();

//        return responseModel;

        Product product = new Product(model);

        Optional<Product> productWasCreated = this.productService.createProductInToDB(product);
//
//        if(productWasCreated.isPresent()){
//            return productWasCreated.get();
//        }
//        return null;

        CreateNewProductResponse response = new CreateNewProductResponse();

//        if (bindingResult.hasErrors()) {
//            ObjectError error = bindingResult.getAllErrors().get(0);
//            String messageKey = error.getDefaultMessage().substring(1,
//                    error.getDefaultMessage().indexOf("}"));
//
//            String errorMessage = messageSource.getMessage(messageKey, new Object[]{responseModel.getIndex()}, locale);
//
//            response.setErrorMessage(errorMessage);

//        } else {
//            productService.createProductInToDB(response);
//            String successMessage = messageSource.getMessage("autoparts.validation.message.step1.done",
//                    new Object[]{request.getEmail()}, locale);
//            response.setSuccessMessage(successMessage);
//        }
        String successMessage = messageSource.getMessage("autoparts.validation.message.step1.done", new Object[]{responseModel.getIndex()}, locale);
        response.setSuccessMessage(successMessage);


        return response;


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
