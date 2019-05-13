package controller;

import dal.PriceDalImp;
import dto.Price;
import model.PriceListResponceModel;
import model.PriceModel;

import model.PriceResponceModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

//    @GetMapping(path = "/list")
//    public List<Price> findAll() {
//        System.out.println("I'm in the GET method!");
//        PriceModel priceModel = new PriceModel(1, 123, 43,2,"active", "4 days", "url");
//        PriceDalImp dal = new PriceDalImp();
//        return dal.readAllFromDB();
//    }

    @GetMapping(path = "/list")
    public PriceListResponceModel findAll(){

        PriceListResponceModel responceModel = new PriceListResponceModel();

        PriceListResponceModel element1 = new PriceListResponceModel();
        PriceListResponceModel element2 = new PriceListResponceModel();

        List<PriceListResponceModel> priceListResponceModels = new ArrayList<>();

        priceListResponceModels.add(element1);
        priceListResponceModels.add(element2);

        responceModel.setPriceListResponceModels(priceListResponceModels);

        return responceModel;

    }
    @GetMapping(path = "/item")
    public PriceResponceModel findItem(Integer id){

        PriceResponceModel responceModel = new PriceResponceModel();



        return responceModel;

    }

    @PostMapping(path = "/item")
    public PriceResponceModel createItem(@RequestBody PriceResponceModel model){

        PriceResponceModel responceModel = new PriceResponceModel();



        return responceModel;

    }
//    @GetMapping(path = "/listpage")
//    public ModelAndView findAllPage() {
//        System.out.println("I'm in the GET method!");
//        UserModel userModel = new UserModel(123, " user name", "url");
//        ModelAndView model = new ModelAndView("testPage");
//        model.addObject("msg", "some message from Controller");
//
//        return model;
//    }
}
