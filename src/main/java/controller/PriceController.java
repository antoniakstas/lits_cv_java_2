package controller;

import dal.PriceDalImp;
import dto.Price;
import model.PriceResponceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
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

    @PostMapping(path = "/update")
    public Price updatePriceInToDB(@ModelAttribute("price") Price price){


        Optional<Price> priceWasUpdated = this.priceService.updatePrice(price);


        if(priceWasUpdated.isPresent()){
            return priceWasUpdated.get();

        }

        return null;
    }
    @RequestMapping(value = "/deletePrice/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deletePriceLine(@PathVariable("id") Long id) {
        priceService.deleteLine(id);
        return "redirect:/getPrice";

    }

    @GetMapping(path = "/list1")
    public List<Price> getPriceByProductId(Long product_id) {

        List<Price> allPrice = priceService.readAllFromDBByProductId(product_id);
        return allPrice;

    }



}