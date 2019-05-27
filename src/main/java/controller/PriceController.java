package controller;

import dal.PriceDalImp;
import dto.Price;
import model.PriceListResponceModel;
import model.PriceModel;

import model.PriceResponceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.PriceService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

@Autowired
private PriceService priceService;

    @GetMapping(path = "/list")
    public List<Price> findAll(){

        List<Price> AllPrice = priceService.findAllPrice();
        return AllPrice;

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
