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
        CreateNewProductResponse response = new CreateNewProductResponse();

        if (!bindingResult.hasErrors()) {
            Optional<Product> productWasCreated = this.productService.createProductInToDB(product);
            String successMessage = messageSource.getMessage("autoparts.validation.message.step1.done", new Object[]{responseModel.getIndex()}, locale);
            response.setSuccessMessage(successMessage);
        } else {
            String errorMessage = messageSource.getMessage("autoparts.validation.message.createproductid", new Object[]{responseModel.getIndex()}, locale);

            response.setErrorMessage(errorMessage);
        }
        return response;
    }

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
