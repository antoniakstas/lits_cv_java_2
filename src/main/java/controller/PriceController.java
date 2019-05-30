package controller;

import dal.PriceDalImp;
import dto.Price;
import model.PriceResponceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.PriceService;


import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired

    private PriceService priceService;

    @GetMapping(path = "/list")
    public List<Price> findAll() {

        List<Price> allPrice = priceService.findAllPrice();
        return allPrice;

    }

    @PostMapping(value= "/add")
    public String createPriceInToDB(@ModelAttribute("price") Price price){

       // if(price.getId() != 0){
            //new person, add it
        boolean priceWasCreated = this.priceService.createPriceInToDB(price);


        if(priceWasCreated){
            return "price created";

        }

        return "price not created";
    }

    @GetMapping(path = "/item")
    public PriceResponceModel findItem(Integer id) {

        PriceResponceModel responceModel = new PriceResponceModel();


        return responceModel;

    }

    @PostMapping(path = "/item")
    public PriceResponceModel createItem(@RequestBody PriceResponceModel model) {

        PriceResponceModel responceModel = new PriceResponceModel();


        return responceModel;

    }
}