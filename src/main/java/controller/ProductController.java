package controller;

import dto.Price;
import dto.Product;
import io.swagger.annotations.Api;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.FileStorageService;
import service.PriceService;
import service.ProductService;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private FileStorageService fileStorageService1;

    @Autowired
    private PriceService priceService;

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
                PriceModel priceModel = new PriceModel(
                        priceItem.getId(),
                        productItemId,
                        Long.valueOf(priceItem.getValue() * priceItem.getMult()),
                        0L,
                        priceItem.getCount(), priceItem.getActive(),
                        priceItem.getDeliverydays(), "URL HAS To Be Here");
                priceModels.add(priceModel);
            }
            ProductWithPricesResponse item = new ProductWithPricesResponse(productItemId,
                    productItem.getIndex(), productItem.getName(), productItem.getManufacturer(),
                    url, null, priceModels);

            response.add(item);
        }
        return response;
    }

    @GetMapping(path = "/list")
    public List<ProductResponseModel> findAll() {
        List<Product> allProduct = productService.findAllProduct();

        List<ProductResponseModel> productResponseModels = new ArrayList<>();
        for (Product productitem : allProduct) {
            ProductResponseModel productResponseModel1 = new ProductResponseModel(productitem.getIndex(), productitem.getName(), productitem.getManufacturer());
            productResponseModels.add(productResponseModel1);
        }
        return productResponseModels;
    }

    @GetMapping(path = "/item")
    public ModelAndView findItem(Long id) {
        Product product = productService.findById(id);
        List<Price> allPriceByProductId =
                priceService.readAllFromDBByProductId(id);
        String url2 = "http://localhost:8880/application/product/updateProduct?id=" + id;
        List<PriceModel> priceModels = new ArrayList<>();

        for (Price priceItem : allPriceByProductId) {
            Long priceItemId = priceItem.getId();
            String idPrice = priceItemId.toString();
            String urlPrice = "http://localhost:8880/application/cart/addToCart?priceId=" + idPrice;

            PriceModel priceModel = new PriceModel(
                    priceItem.getId(),
                    id,
                    Long.valueOf(priceItem.getValue() * priceItem.getMult()),
                    2L,
                    priceItem.getCount(), priceItem.getActive(),
                    priceItem.getDeliverydays(), urlPrice);
            priceModels.add(priceModel);
        }
        ProductWithPricesResponse item = new ProductWithPricesResponse(id,
                product.getIndex(), product.getName(), product.getManufacturer(),
                null, url2, priceModels);


        ModelAndView modelAndView = new ModelAndView("productItemPage");
        modelAndView.addObject("productItem", item);

        return modelAndView;
    }

    @PostMapping(path = "/item")
    public CreateNewProductResponse create(Locale locale, @Valid @RequestBody ProductResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        ProductResponseModel responseModel = new ProductResponseModel();
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

            if (productWasUpdate.isPresent()) {
                productWasUpdate.get();

            } else {
                String errorMessage = messageSource.getMessage("autoparts.validation.message.updateproductid", new Object[]{responseModel.getIndex()}, locale);
                response.setErrorMessage(errorMessage);
            }
        }
        return response;

    }

    @GetMapping(path = "/delete")
    public String deleteProductLine(Integer id) {
        productService.deletePtoduct(Long.valueOf(id));
        return null;
    }

    @GetMapping(path = "/productPage")
    public ModelAndView prPage() {
        List<Product> allProduct = productService.findAllProduct();
        List<ProductWithPricesResponse> response = new ArrayList<>();

        List<Long> productIdList = new ArrayList<>();

        for (Product productItem : allProduct) {
            productIdList.add(productItem.getId());
        }

        for (Product productItem : allProduct) {
            Long productItemId = productItem.getId();
            String id = productItemId.toString();
            String url = "http://localhost:8880/application/product/item?id=" + id;
            String url2 = "http://localhost:8880/application/product/updateProduct?id=" + id;

            List<Price> allPriceByProductId =
                    priceService.readAllFromDBByProductId(productItemId);

            List<PriceModel> priceModels = new ArrayList<>();

            for (Price priceItem : allPriceByProductId) {

                Long priceItemId = priceItem.getId();
                String idPrice = priceItemId.toString();
                String urlPrice = "http://localhost:8880/application/cart/addToCart?priceId=" + idPrice;
                PriceModel priceModel = new PriceModel(
                        priceItem.getId(),
                        productItemId,
                        Long.valueOf(priceItem.getValue() * priceItem.getMult()),
                        2L,
                        priceItem.getCount(), priceItem.getActive(),
                        priceItem.getDeliverydays(), urlPrice);
                priceModels.add(priceModel);
            }
            ProductWithPricesResponse item = new ProductWithPricesResponse(productItemId,
                    productItem.getIndex(), productItem.getName(), productItem.getManufacturer(),
                    url, url2, priceModels);

            response.add(item);
        }

        ModelAndView modelAndView = new ModelAndView("productPage");
        modelAndView.addObject("response", response);

        return modelAndView;
    }

    @GetMapping(path = "/addProductPage")
    public ModelAndView addPage() {

        AddProductModel addProductModel = new AddProductModel();

        if (addProductModel == null) {
            addProductModel = new AddProductModel();

        }
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("productForm", addProductModel);
        return modelAndView;
    }

    @PostMapping("/addPr")
    public ModelAndView Submit(@RequestParam("file") MultipartFile file, AddProductModel model) {
        ModelAndView modelAndView = new ModelAndView();

        model.getIndex();
        model.getName();
        model.getManufacturer();

        Product product = new Product((long) 1, model.getIndex(), model.getName(), model.getManufacturer());
        productService.createProductInToDB(product);
        String fileName =
                fileStorageService1.storeFile1(file, product.getId());
        return new ModelAndView("redirect:/product/productPage");
    }


    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) throws IOException {
        Product product = productService.findById(id);
        Long ineg = product.getId();

        ClassPathResource imgFile = new ClassPathResource("/image/product/" + ineg + ".jpg");

        try {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(imgFile.getInputStream()));
        } catch (FileNotFoundException ex) {
            ClassPathResource imgFile1 = new ClassPathResource("/image/product/dafaultPage.jpg");


            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(imgFile1.getInputStream()));

        }

    }

    @GetMapping(path = "/updateProduct")
    public ModelAndView update(Long id) {
        Product product = productService.findById(id);
        product.getId();

        AddProductModel addProductModel = new AddProductModel();
        addProductModel.getId();


        ModelAndView modelAndView = new ModelAndView("updateProduct");
        modelAndView.addObject("productUp", product);
        return modelAndView;
    }

    @PostMapping(path = "/updatePr")
    public ModelAndView updatePrInToDB( @ModelAttribute("product") Product product, Long id, AddProductModel addProductModel) {
        ModelAndView modelAndView = new ModelAndView();
        product.getId();
        product.getIndex();
        product.getName();
        product.getManufacturer();


        Optional<Product> productWasUpdated = this.productService.updateProductInToDB(product);

        modelAndView.addObject(productWasUpdated);

        return new ModelAndView("redirect:/product/productPage");
    }

}


