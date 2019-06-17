package controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import dto.Price;
import dto.Product;
import io.swagger.annotations.Api;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import service.PriceService;
import service.ProductService;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @Autowired
    private PriceService priceService;

//    @GetMapping(path = "/list/prices")
//    public List<Long> findAllProduct() {
////        List<ProductResponseModel> productResponseModelList = null;
//
//        List<Product> allProduct = productService.findAllProduct();
//        List<Long> productIdList = new ArrayList<>();
//        for (Product productitem:allProduct) {
//            productIdList.add(productitem.getId());
//           }
//
////        priceService.findAllProductId();
//        return productIdList;
//    }

    @GetMapping(path = "/list/price")
    public List<ProductWithPricesResponse> findAllProductsWithPrices() {

        List<ProductWithPricesResponse> response = new ArrayList<>();


        List<Product> allProduct = productService.findAllProduct();
        List<Long> productIdList = new ArrayList<>();


        for (Product productItem : allProduct) {
            productIdList.add(productItem.getId());
        }


        for (Product productItem : allProduct) {

            Long productItemId = productItem.getId();
            String id = productItemId.toString();
            String url = "http://localhost:8880/application/product/item?id=" + id;

            List<Price> allPriceByProductId =
                    priceService.readAllFromDBByProductId(productItemId);

            List<PriceModel> priceModels = new ArrayList<>();

            for (Price priceItem : allPriceByProductId) {
                PriceModel priceModel = new PriceModel(priceItem.getId(),
                        productItemId,
                        Long.valueOf(priceItem.getValue() * priceItem.getMult())
                        , 0L, priceItem.getMult(), priceItem.getActive(),
                        priceItem.getDeliverydays(), "URL HAS To Be Here");
                priceModels.add(priceModel);
            }


            ProductWithPricesResponse item = new ProductWithPricesResponse(productItemId,
                    productItem.getIndex(), productItem.getName(), productItem.getManufacturer(),
                    url, priceModels);

            response.add(item);
        }


        return response;
    }

    @GetMapping(path = "/list")
    public List<ProductResponseModel> findAll() {
//        List<ProductResponseModel> productResponseModelList = null;

        List<Product> allProduct = productService.findAllProduct();

        List<ProductResponseModel> productResponseModels = new ArrayList<>();
        for (Product productitem:allProduct) {
//            ProductResponseModel productResponseModel = new ProductResponseModel(productitem);
//
            ProductResponseModel productResponseModel1 = new ProductResponseModel(productitem.getIndex(),productitem.getIndex(),productitem.getManufacturer());
            productResponseModels.add(productResponseModel1);
        }
        return productResponseModels;
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

//    @GetMapping(path = "/delete")
//    public ProductResponseModel deleteItem(Integer id) {
//        findAll();
//        ProductResponseModel responseModel = new ProductResponseModel();
//
//        findAll().remove(id);
//        return responseModel;
//    }

    @PostMapping(path = "/update")
    public CreateNewProductResponse update(Locale locale, @Valid @RequestBody ProductResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        ProductResponseModel responseModel = new ProductResponseModel();
        Product product = new Product(model);

        CreateNewProductResponse response = new CreateNewProductResponse();
        if (!bindingResult.hasErrors()) {
            Optional<Product> productWasUpdate = this.productService.updateProductInToDB(product);

            String successMessage = messageSource.getMessage("autoparts.validation.message.step1.done", new Object[]{responseModel.getIndex()}, locale);
            response.setSuccessMessage(successMessage);

            if(productWasUpdate.isPresent()){
                productWasUpdate.get();

            } else {
            String errorMessage = messageSource.getMessage("autoparts.validation.message.updateproductid", new Object[]{responseModel.getIndex()}, locale);

            response.setErrorMessage(errorMessage);
        }

        }
        return response;
    }

    @GetMapping(path = "/delete")
//    @RequestMapping(value = "/deleteProduct/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProductLine( Integer id) {
        productService.deletePtoduct(Long.valueOf(id));
        return null;

    }

//
//    @GetMapping(path = "/item")
//    public ProductResponseModel findItem(Integer id) {
//        ProductResponseModel responseModel = new ProductResponseModel();
//
//        return responseModel;
//    }

}
