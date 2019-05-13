package controller;

import dal.PriceDalImp;
import dto.Price;
import model.PriceModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @GetMapping(path = "/list")
    public List<Price> findAll() {
        System.out.println("I'm in the GET method!");
        PriceModel priceModel = new PriceModel(1, 123, 43,2,"active", "4 days", "url");
        PriceDalImp dal = new PriceDalImp();
        dal.readAllFromDB();
        return dal.readAllFromDB();
    }

//
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
