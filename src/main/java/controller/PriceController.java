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
import java.util.Optional;

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
    public Price createPriceInToDB(@ModelAttribute("price") Price price){

       // if(price.getId() != 0){
            //new person, add it
        Optional<Price> priceWasCreated = this.priceService.createPriceInToDB(price);


        if(priceWasCreated.isPresent()){
            return priceWasCreated.get();

        }

        return null;
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